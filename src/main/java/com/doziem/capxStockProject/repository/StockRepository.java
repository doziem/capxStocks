package com.doziem.capxStockProject.repository;

import com.doziem.capxStockProject.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
