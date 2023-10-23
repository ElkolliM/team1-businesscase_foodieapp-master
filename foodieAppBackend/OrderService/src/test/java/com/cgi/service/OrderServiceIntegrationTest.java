package com.cgi.service;

import com.cgi.exception.OrderNotFoundException;
import com.cgi.model.Dish;
import com.cgi.model.Order;
import com.cgi.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@DataMongoTest
@ActiveProfiles("test")

//Need to be fixed (request sent to Deepan)
public class OrderServiceIntegrationTest {
    List<Dish> dishList = new ArrayList<Dish>(Arrays.asList(
            new Dish("1", "Pasta", "15", "Cheesy", "url"),
            new Dish("2", "Noodles", "11", "Seafood", "url")
    ));

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void getOrderByIdForValidOrder() throws OrderNotFoundException {
        String input = "1";
        Order expectedOrder = new Order("Momo Restaurant",dishList);
        //Optional<Order> orderOptional = Optional.of(expectedOrder);
        orderRepository.insert(expectedOrder);
        Order actualOrder = orderService.getOrderById("6");
        assertNotNull(actualOrder);
        assertEquals(actualOrder.getOrderId(),"6");

    }

}
