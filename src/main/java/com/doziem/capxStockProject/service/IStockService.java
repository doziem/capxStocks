package com.doziem.capxStockProject.service;


import com.doziem.capxStockProject.dto.PortfolioMetrics;
import com.doziem.capxStockProject.dto.StockDto;
import com.doziem.capxStockProject.model.Stock;

import java.util.List;

public interface IStockService {

    StockDto createStock(StockDto stock);

    StockDto updateExistingStock(Long id, StockDto stockDto);

    List<StockDto> getAllStock();

    StockDto getStockById(Long stockId);

    void deleteStock(Long stockId);




}
