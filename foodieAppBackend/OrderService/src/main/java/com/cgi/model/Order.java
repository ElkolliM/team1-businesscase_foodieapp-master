package com.cgi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class Order {


    @Id
    private String orderId;
    private String restaurantName;
    private List<Dish> dishList;
    private boolean isNotReady;
    private LocalDateTime orderPlacedAt;

    public Order() {
    }

    public Order(String restaurantName, List<Dish> dishList) {
        this.restaurantName = restaurantName;
        this.dishList = dishList;
        this.isNotReady = false;
        this.orderPlacedAt = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public boolean getReady() {
        return isNotReady;
    }

    public void setReady(boolean ready) {
        isNotReady = ready;
    }

    public LocalDateTime getOrderPlacedAt() {
        return orderPlacedAt;
    }

    public void setOrderPlacedAt(LocalDateTime orderPlacedAt) {
        this.orderPlacedAt = orderPlacedAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", dishList=" + dishList +
                ", isReady=" + isNotReady +
                ", orderPlacedAt=" + orderPlacedAt +
                '}';
    }
}
