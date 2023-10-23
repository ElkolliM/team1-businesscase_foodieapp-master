package com.cgi.service;

import com.cgi.exception.RestaurantAlreadyExistsException;
import com.cgi.exception.RestaurantNotFoundException;
import com.cgi.model.Restaurant;
import com.cgi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public Restaurant registerRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistsException {
        if(restaurantRepository.existsById(restaurant.getRestaurantId()))
            throw new RestaurantAlreadyExistsException("Restaurant already exists");

        restaurantRepository.insert(restaurant);

        return restaurant;
    }

    @Override
    public List<Restaurant> viewAllRestaurants() {
        List<Restaurant> restaurants;
        return restaurants = restaurantRepository.findAll();
    }


//    @Override
//    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
//        Optional<Restaurant>optionalRestaurant = restaurantRepository.findById(restaurant.getRestaurantId());
//        if(optionalRestaurant.isEmpty())
//            throw new RestaurantNotFoundException("Restaurant not found");
//        boolean restaurantStatus = optionalRestaurant.get().isRestaurantStatus();
//        restaurantStatus = !restaurantStatus;
//        optionalRestaurant.get().setRestaurantStatus(restaurantStatus);
//        restaurantRepository.save(optionalRestaurant.get());
//        return optionalRestaurant.get();
//    }

    @Override
    public List<Restaurant> viewAllAcceptedRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream()
                .filter(Restaurant::isRestaurantStatus)
                .collect(Collectors.toList());
    }

    @Override
    public List<Restaurant> viewAllRequestsRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream()
                .filter(r-> !r.isRestaurantStatus())
                .collect(Collectors.toList());
    }

    @Override
    public Restaurant getRestaurantById(String restaurantId) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if(restaurantOptional.isPresent())
            return restaurantOptional.get();

        throw new RestaurantNotFoundException("Restaurant not found");
    }

    @Override
    public Restaurant updateRestaurantStatus(String restaurantId) throws RestaurantNotFoundException {
        Optional <Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        if(optionalRestaurant.isPresent()){

            boolean restaurantStatus = optionalRestaurant.get().isRestaurantStatus();
            restaurantStatus = !restaurantStatus;
            optionalRestaurant.get().setRestaurantStatus(restaurantStatus);
            restaurantRepository.save(optionalRestaurant.get());
            return optionalRestaurant.get();
        }
        throw new RestaurantNotFoundException("Restaurant not found");
    }

    @Override
    public Restaurant removeRestaurantById(String restaurantId) throws RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        if(optionalRestaurant.isEmpty())
            throw new RestaurantNotFoundException("Restaurant not found");
            restaurantRepository.deleteById(restaurantId);
            return optionalRestaurant.get();
    }

}
