package com.cgi.service;

import com.cgi.exception.OrderNotFoundException;
import com.cgi.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order createOrder (Order order);
    void removeDishFromOrderById (String orderId, String dishId);
    Order getOrderById (String orderId) throws OrderNotFoundException;
    Order updateOrderStatus (String orderId) throws OrderNotFoundException;
    List<Order> viewAllOrders ();
}
