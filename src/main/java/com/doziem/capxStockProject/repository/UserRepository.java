package com.doziem.capxStockProject.repository;

import com.doziem.capxStockProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
