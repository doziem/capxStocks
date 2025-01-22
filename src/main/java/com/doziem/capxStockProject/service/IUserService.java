package com.doziem.capxStockProject.service;

import com.doziem.capxStockProject.model.User;

public interface IUserService {
    User findByEmail(String email);
}
