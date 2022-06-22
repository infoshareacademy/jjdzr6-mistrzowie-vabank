package com.infoshareacademy.domain;

public class Order{
    private int orderId;
    private Wine wineId;
    private User userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", vineId=" + wineId +
                ", userId=" + userId +
                '}';
    }

    public Order(int orderId, Wine wineId, User userId) {
        this.orderId = orderId;
        this.wineId = wineId;
        this.userId = userId;

    }
}
