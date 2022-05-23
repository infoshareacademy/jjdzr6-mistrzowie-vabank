package com.infoshareacademy.domain;

public class Order{
    private int orderId;
    private Vine vineId;
    private User userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", vineId=" + vineId +
                ", userId=" + userId +
                '}';
    }

    public Order(int orderId, Vine vineId, User userId) {
        this.orderId = orderId;
        this.vineId = vineId;
        this.userId = userId;

    }
}
