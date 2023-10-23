package com.cgi.service;

import com.cgi.exception.OrderNotFoundException;
import com.cgi.model.Dish;
import com.cgi.model.Order;
import com.cgi.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {


    List<Dish> dishList = new ArrayList<Dish>(Arrays.asList(
            new Dish("1", "Pasta", "15", "Cheesy", "url"),
            new Dish("2", "Noodles", "11", "Seafood", "url")
    ));

    @InjectMocks
    private OrderServiceImpl testOrderService;

    @Mock
    private OrderRepository testOrderRepository;

    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        //testOrderService = new OrderService(testOrderRepository);
    }


    @Test
    void testingCreateOrder() {
        //given
        Order order = new Order("Momo Restaurant",dishList);
        Order createdOrder = testOrderService.createOrder(order);
        assertNotNull(createdOrder);
        assertEquals(order.getOrderId(),createdOrder.getOrderId());
    }
//Need to be fixed
    @Test
    void removeDishFromOrderById() {
        Order order = new Order("Momo Restaurant",dishList);
        Order createdOrder = testOrderService.createOrder(order);
        testOrderService.removeDishFromOrderById("10","1");
        assertNull(createdOrder.getDishList().get(0));



    }

    @Test
    void getOrderByIdForValidOrder() throws OrderNotFoundException {
        String input = "2";
        Order expectedOrder = new Order("Momo Restaurant",dishList);
        Optional<Order> orderOptional = Optional.of(expectedOrder);

        Mockito.when(testOrderRepository.findById(input)).thenReturn(orderOptional);
        Order actualOrder = testOrderService.getOrderById(input);
        assertNotNull(actualOrder);
        assertEquals(actualOrder.getOrderId(),expectedOrder.getOrderId());

        verify(testOrderRepository,Mockito.times(1)).findById(input);
    }

    @Test
    void getOrderByIdForInvalidOrder() throws OrderNotFoundException {
        String input = "2";
        Order expectedOrder = new Order("Momo Restaurant",dishList);
        Optional<Order> orderOptional = Optional.empty();

        Mockito.when(testOrderRepository.findById(input)).thenReturn(orderOptional);

        assertThrows(OrderNotFoundException.class,()->{
            testOrderService.getOrderById(input);
        });

        verify(testOrderRepository,Mockito.times(1)).findById(input);
    }

    //Need to be fixed
    @Test
    void updateOrderStatus() throws OrderNotFoundException {
        String input = "2";
        Order expectedOrder = new Order("Momo Restaurant",dishList);
        testOrderService.updateOrderStatus(expectedOrder.getOrderId());
        Optional<Order> orderOptional = Optional.of(expectedOrder);

        Mockito.when(testOrderRepository.findById(input)).thenReturn(orderOptional);
        assertTrue(expectedOrder.getReady());


    }

    @Test
    void viewAllOrders() {
        testOrderService.viewAllOrders();
        verify(testOrderRepository).findAll();
    }
}