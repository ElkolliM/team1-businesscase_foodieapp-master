package com.cgi.controller;

import com.cgi.exception.DishNotFoundException;
import com.cgi.exception.OrderNotFoundException;
import com.cgi.model.Order;
import com.cgi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrderHandler(@RequestBody Order order){
        ResponseEntity<?> responseEntity;
            responseEntity = new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/{orderId}/{dishId}")
    public ResponseEntity<?> removeDishFromOrderByDishIdHandler(@PathVariable("orderId") String orderId,@PathVariable("dishId") String dishId){
        ResponseEntity<?> responseEntity;

        orderService.removeDishFromOrderById(orderId,dishId);

        responseEntity = new ResponseEntity<String>("Dish removed successfully", HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderByIdHandler(@PathVariable ("orderId") String orderId){
        ResponseEntity<?> responseEntity;
        try{
            Order order = orderService.getOrderById(orderId);
            responseEntity = new ResponseEntity<>(order,HttpStatus.OK);
        }catch (OrderNotFoundException e){
            responseEntity = new ResponseEntity<>("Order not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("{orderId}")
    public ResponseEntity<?> updateOrderStatus(@PathVariable ("orderId") String orderId,@RequestBody Order order){
        ResponseEntity<?> responseEntity;
        try{
            responseEntity = new ResponseEntity<>(orderService.updateOrderStatus(orderId),HttpStatus.OK);
        }catch (OrderNotFoundException e){
            responseEntity = new ResponseEntity<>("Order not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<?> viewAllOrdersHandler(){
        return new ResponseEntity<>(orderService.viewAllOrders(),HttpStatus.OK);
    }

}
