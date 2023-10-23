package com.cgi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Restaurant {

    @Id
    private String restaurantId;
    private String restaurantName;
    private String restaurantCategory;
    private String restaurantLocation;
    private String restaurantImage;
    private boolean restaurantStatus;

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String restaurantCategory, String restaurantLocation, String restaurantImage) {
        this.restaurantName = restaurantName;
        this.restaurantCategory = restaurantCategory;
        this.restaurantLocation = restaurantLocation;
        this.restaurantImage = restaurantImage;
        this.restaurantStatus = false;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public boolean isRestaurantStatus() {
        return restaurantStatus;
    }

    public void setRestaurantStatus(boolean restaurantStatus) {
        this.restaurantStatus = restaurantStatus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId='" + restaurantId + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantCategory='" + restaurantCategory + '\'' +
                ", restaurantLocation='" + restaurantLocation + '\'' +
                ", restaurantImage='" + restaurantImage + '\'' +
                '}';
    }
}
