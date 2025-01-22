package com.doziem.capxStockProject.service;

import com.doziem.capxStockProject.dto.PortfolioDto;
import com.doziem.capxStockProject.model.Portfolio;

import java.util.List;
import java.util.Optional;

public interface IPortfolioService {
    Portfolio createPortfolio(PortfolioDto portfolio, Long userId );

    List<Portfolio> getPortfoliosByUser(Long userId);

    List<PortfolioDto> getAllPortfolio();

    Portfolio updatePortfolio(Long portfolioId, Portfolio updatedPortfolio);

    Optional<Portfolio> getPortfolio(Long portfolioId);

    void deletePortfolio(Long portfolioId);
}
