package com.doziem.capxStockProject.repository;

import com.doziem.capxStockProject.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio,Long> {
    List<Portfolio> findByUserId(Long userId);

    Optional<Portfolio> findByName(String name);
}
