package com.doziem.capxStockProject.service;

import com.doziem.capxStockProject.dto.PortfolioDto;
import com.doziem.capxStockProject.model.Portfolio;

import java.util.List;
import java.util.Optional;

public class PortfolioServiceImpl implements IPortfolioService{
    @Override
    public Portfolio createPortfolio(PortfolioDto portfolio, Long userId) {
        return null;
    }

    @Override
    public List<Portfolio> getPortfoliosByUser(Long userId) {
        return List.of();
    }

    @Override
    public List<PortfolioDto> getAllPortfolio() {
        return List.of();
    }

    @Override
    public Portfolio updatePortfolio(Long portfolioId, Portfolio updatedPortfolio) {
        return null;
    }

    @Override
    public Optional<Portfolio> getPortfolio(Long portfolioId) {
        return Optional.empty();
    }

    @Override
    public void deletePortfolio(Long portfolioId) {

    }
}
