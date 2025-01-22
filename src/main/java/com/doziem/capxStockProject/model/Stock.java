package com.doziem.capxStockProject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Table(name = "capx_stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ticker;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer quantity;

    @Column
    private Double buyPrice;

    @Column
    private Long volume;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = true)
    private Portfolio portfolio;


    public Stock() {

    }

    public Stock(String ticker, String s, int i, double price, Object o, Object o1) {
    }
}


