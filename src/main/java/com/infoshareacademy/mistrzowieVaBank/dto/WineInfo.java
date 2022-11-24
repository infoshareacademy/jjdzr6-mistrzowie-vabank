package com.infoshareacademy.mistrzowieVaBank.dto;


import com.infoshareacademy.mistrzowieVaBank.entity.Wine;

import java.math.BigDecimal;

public class WineInfo {
    private Long id;
    private String name;
    private BigDecimal price;
    private String spec;

    private byte[] image;

    public WineInfo() {
    }

    public WineInfo(Wine wine) {
        this.id = wine.getId();
        this.name = wine.getName();
        this.price = wine.getPrice();
        this.spec = wine.getSpec();
        this.image = wine.getImage();
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

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
