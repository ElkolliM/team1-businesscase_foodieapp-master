package com.cgi.controller;

import com.cgi.exception.RestaurantAlreadyExistsException;
import com.cgi.exception.RestaurantNotFoundException;
import com.cgi.model.Restaurant;
import com.cgi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController (RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<?> registerRestaurantHandler (@RequestBody Restaurant restaurant){
        ResponseEntity<?> responseEntity;

        try {
            responseEntity = new ResponseEntity<>(restaurantService.registerRestaurant(restaurant), HttpStatus.CREATED);
        }catch(RestaurantAlreadyExistsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
//
    @GetMapping
    public ResponseEntity<?> viewAllRestaurantsHandler(){
        return new ResponseEntity<>(restaurantService.viewAllRestaurants(),HttpStatus.OK);
    }



//    @PutMapping()
//    public ResponseEntity<?> updateRestaurantHandler(@PathVariable ("restaurantId") String restaurantId, @RequestBody Restaurant restaurant) throws RestaurantNotFoundException {
//        try {
//            return new ResponseEntity<>(restaurantService.updateRestaurant(restaurant), HttpStatus.OK);
//        }catch(RestaurantNotFoundException e){
//            return new ResponseEntity<>("Restaurant not found",HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<?> updateRestaurantStatusHandler(@PathVariable ("restaurantId") String restaurantId) throws RestaurantNotFoundException {
        try {
            return new ResponseEntity<>(restaurantService.updateRestaurantStatus(restaurantId), HttpStatus.OK);
        }catch(RestaurantNotFoundException e){
            return new ResponseEntity<>("Restaurant not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/requests")
    public ResponseEntity<?> viewAllRestaurantRequestsHandler(){
        try {
            return new ResponseEntity<>(restaurantService.viewAllRequestsRestaurants(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable ("restaurantId") String restaurantId) throws RestaurantNotFoundException{
        try{
            return new ResponseEntity<>(restaurantService.getRestaurantById(restaurantId),HttpStatus.OK);
        } catch (RestaurantNotFoundException e) {
            return new ResponseEntity<>("Restaurant not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/approved")
    public ResponseEntity<?> viewAllAcceptedRestaurantsHandler(){
        try {
            return new ResponseEntity<>(restaurantService.viewAllAcceptedRestaurants(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{restaurantId}")
    public ResponseEntity<?> removeRestaurantByIdHandler(@PathVariable ("restaurantId") String restaurantId) throws RestaurantNotFoundException {
        try{
            return new ResponseEntity<>(restaurantService.removeRestaurantById(restaurantId),HttpStatus.OK);
        }catch (RestaurantNotFoundException e){
            return new ResponseEntity<>("Restaurant not found",HttpStatus.NOT_FOUND);
        }

    }

}
