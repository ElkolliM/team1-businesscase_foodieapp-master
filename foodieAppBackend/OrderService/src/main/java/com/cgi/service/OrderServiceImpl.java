package com.cgi.service;

import com.cgi.exception.OrderNotFoundException;
import com.cgi.model.Dish;
import com.cgi.model.Order;
import com.cgi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        if(!orderRepository.existsById(order.getOrderId()))
        orderRepository.insert(order);
        return order;
    }

    @Override
    public void removeDishFromOrderById(String orderId, String dishId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        List<Dish> dishList = optionalOrder.get().getDishList();
        dishList.removeIf(n->n.getDishId().equals(dishId));
        optionalOrder.get().setDishList(dishList);
        orderRepository.save(optionalOrder.get());

    }

    @Override
    public Order getOrderById(String orderId) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isPresent())
            return orderOptional.get();

        throw new OrderNotFoundException("Order not found");

    }

    @Override
    public Order updateOrderStatus(String orderId) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if(orderOptional.isPresent()) {
            boolean orderStatus = orderOptional.get().getReady();
            orderStatus = !orderStatus;
            orderOptional.get().setReady(orderStatus);
            orderRepository.save(orderOptional.get());
            return orderOptional.get();
        }else{
            throw new OrderNotFoundException("Order not found");
        }
    }

    @Override
    public List<Order> viewAllOrders() {
        List<Order> orders;
        return orders = orderRepository.findAll();
    }
}
