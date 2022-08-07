package com.infoshareacademy.mistrzowieVaBank.domain;

import java.time.LocalDate;

public class Order{
    private int orderId;
    private Wine wineId;
    private User userId;
    private LocalDate orderDate;

    public Order(int orderId, Wine wineId, User userId, LocalDate orderDate) {
        this.orderId = orderId;
        this.wineId = wineId;
        this.userId = userId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public Wine getWineId() {
        return wineId;
    }

    public User getUserId() {
        return userId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", wineId=" + wineId +
                ", userId=" + userId +
                ", orderDate=" + orderDate +
                '}';
    }
}
