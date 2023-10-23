package com.cgi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dish {

    @Id
    private String dishId;
    private String dishName;
    private String dishPrice;
    private String dishDetails;
    private String dishImage;

    public Dish() {
    }

    public Dish(String dishId, String dishName, String dishPrice, String dishDetails, String dishImage) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishDetails = dishDetails;
        this.dishImage = dishImage;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishDetails() {
        return dishDetails;
    }

    public void setDishDetails(String dishDetails) {
        this.dishDetails = dishDetails;
    }

    public String getDishImage() {
        return dishImage;
    }

    public void setDishImage(String dishImage) {
        this.dishImage = dishImage;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId='" + dishId + '\'' +
                ", dishName='" + dishName + '\'' +
                ", dishPrice='" + dishPrice + '\'' +
                ", dishDetails='" + dishDetails + '\'' +
                ", dishImage='" + dishImage + '\'' +
                '}';
    }
}
