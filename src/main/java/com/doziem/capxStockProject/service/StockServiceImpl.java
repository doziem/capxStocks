package com.doziem.capxStockProject.service;

import com.doziem.capxStockProject.dto.StockDto;
import com.doziem.capxStockProject.exception.ResourceNotFoundException;
import com.doziem.capxStockProject.model.Portfolio;
import com.doziem.capxStockProject.model.Stock;
import com.doziem.capxStockProject.repository.PortfolioRepository;
import com.doziem.capxStockProject.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class StockServiceImpl implements IStockService{

    @Autowired
    public StockRepository stockRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    @Transactional
    public StockDto createStock(StockDto stockDto) {
        if (stockDto == null || stockDto.getPortfolio() == null || stockDto.getPortfolio().getName() == null) {
            throw new IllegalArgumentException("Invalid stock or portfolio details.");
        }

        String portfolioName = stockDto.getPortfolio().getName().trim();

        Portfolio portfolio = portfolioRepository.findByName(portfolioName)
                .orElseGet(() -> portfolioRepository.save(new Portfolio(portfolioName)));

        Stock stock = new Stock();
        stock.setName(stockDto.getName());
        stock.setTicker(stockDto.getTicker());
        stock.setQuantity(stockDto.getQuantity());
        stock.setBuyPrice(stockDto.getBuyPrice());
        stock.setVolume(stockDto.getVolume());
        stock.setPortfolio(portfolio);

        return StockDto.fromStockEntity(stockRepository.save(stock));
    }


    @Override
    @Transactional
    public StockDto updateExistingStock(Long id, StockDto stockDto) {
        return stockRepository.findById(id)
                .map(exixtingStock->updateExistingStockFrom(exixtingStock, stockDto))
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
    }

    private StockDto updateExistingStockFrom(Stock existingStock, StockDto request) {

        existingStock.setName(request.getName() != null ? request.getName() : existingStock.getName());
        existingStock.setBuyPrice(request.getBuyPrice() != null ? request.getBuyPrice() : existingStock.getBuyPrice());
        existingStock.setTicker(request.getTicker() != null ? request.getTicker() : existingStock.getTicker());
        existingStock.setQuantity(request.getQuantity() != null ? request.getQuantity() : existingStock.getQuantity());
        existingStock.setVolume(request.getVolume() != null ? request.getVolume() : existingStock.getVolume());

        // Handle portfolio updates
        if (request.getPortfolio() != null) {
            String portfolioName = request.getPortfolio().getName().trim();
            Portfolio portfolio = portfolioRepository.findByName(portfolioName)
                    .orElseGet(() -> {
                        Portfolio newPortfolio = new Portfolio();
                        newPortfolio.setName(portfolioName);
                        return portfolioRepository.save(newPortfolio); // Save only when creating a new one
                    });
            existingStock.setPortfolio(portfolio);
        }

        Stock updatedStock = stockRepository.save(existingStock);
        return StockDto.fromStockEntity(updatedStock);
    }

    @Override
    public List<StockDto> getAllStock() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream()
                .map(StockDto::fromStockEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StockDto getStockById(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(()->new ResourceNotFoundException("Stock not found"));
        return StockDto.fromStockEntity(stock);
    }


    @Override
    public void deleteStock(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
        stockRepository.delete(stock);
    }

}
