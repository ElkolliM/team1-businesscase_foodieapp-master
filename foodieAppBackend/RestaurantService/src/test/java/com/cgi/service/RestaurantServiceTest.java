package com.cgi.service;

import com.cgi.exception.RestaurantAlreadyExistsException;
import com.cgi.model.Restaurant;
import com.cgi.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @InjectMocks
    private RestaurantServiceImpl restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        //testOrderService = new OrderService(testOrderRepository);
    }


    @Test
    void restaurantCreated() throws RestaurantAlreadyExistsException {
        //given
        Restaurant restaurant = new Restaurant("Momo Restaurant","Pasta","MTL","url");
        Restaurant createdRestaurant = restaurantService.registerRestaurant(restaurant);
        assertNotNull(createdRestaurant);
        assertEquals(restaurant.getRestaurantId(),createdRestaurant.getRestaurantId());
    }
}
