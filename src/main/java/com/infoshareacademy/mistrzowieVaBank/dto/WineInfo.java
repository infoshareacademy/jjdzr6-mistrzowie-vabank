package com.infoshareacademy.mistrzowieVaBank.dto;


import com.infoshareacademy.mistrzowieVaBank.entity.Wine;

import java.math.BigDecimal;

public class WineInfo {
    private Long id;
    private String name;
    private BigDecimal price;
 
    public WineInfo() {
    }
 
    public WineInfo(Wine wine) {
        this.id = wine.getId();
        this.name = wine.getName();
        this.price = wine.getPrice();
    }
 
    // Using in JPA/Hibernate query
    public WineInfo(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
