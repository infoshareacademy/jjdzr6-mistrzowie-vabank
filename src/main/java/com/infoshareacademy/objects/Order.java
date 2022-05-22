package com.infoshareacademy.objects;

public class Order {
    int orderId;
    int vineId = Vine.getVineId();
    int userId = User.getUserId();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getVineId() {
        return vineId;
    }

    public void setVineId(int vineId) {
        this.vineId = vineId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
