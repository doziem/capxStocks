package com.doziem.capxStockProject.dto;

import com.doziem.capxStockProject.model.Portfolio;
import lombok.Getter;
import lombok.Setter;

public class PortfolioDto {
    private Long id;
    private String name;
    private UserDto user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }


    public static PortfolioDto fromPortfolioEntity(Portfolio portfolio) {
        PortfolioDto dto = new PortfolioDto();
        dto.setId(portfolio.getId());
        dto.setName(portfolio.getName());
        if (portfolio.getUser() != null) {
            dto.setUser(UserDto.fromEntity(portfolio.getUser()));
        }else {
            dto.setUser(null);
        }
        return dto;
    }

    public static Portfolio toPortfolioEntity(PortfolioDto dto) {
        Portfolio portfolio = new Portfolio();
        portfolio.setId(dto.getId());
        portfolio.setName(dto.getName());
        return portfolio;
    }

}
