package com.cgi.service;

import com.cgi.exception.RestaurantAlreadyExistsException;
import com.cgi.exception.RestaurantNotFoundException;
import com.cgi.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {

    Restaurant registerRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException;
    List <Restaurant> viewAllRestaurants();
    //Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;
    List<Restaurant> viewAllAcceptedRestaurants();
    List<Restaurant> viewAllRequestsRestaurants();
    Restaurant getRestaurantById (String restaurantId) throws RestaurantNotFoundException;
    Restaurant updateRestaurantStatus (String restaurantId) throws RestaurantNotFoundException;
    Restaurant removeRestaurantById (String restaurantId) throws RestaurantNotFoundException;

}
