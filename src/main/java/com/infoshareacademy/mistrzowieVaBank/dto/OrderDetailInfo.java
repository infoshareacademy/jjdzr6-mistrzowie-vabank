package com.infoshareacademy.mistrzowieVaBank.dto;

import java.math.BigDecimal;

public class OrderDetailInfo {
    private Long id;

    private Long wineId;
    private String wineName;

    private int quantity;
    private BigDecimal price;
    private BigDecimal amount;

    public OrderDetailInfo() {

    }

    // Using for JPA/Hibernate Query.
    public OrderDetailInfo(Long id, Long wineId, //
                           String wineName, int quantity, BigDecimal price, BigDecimal amount) {
        this.id = id;
        this.wineId = wineId;
        this.wineName = wineName;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWineId() {
        return wineId;
    }

    public void setWineId(Long wineId) {
        this.wineId = wineId;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
