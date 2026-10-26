package com.foodcatalogue.order_service.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodcatalogue.order_service.dto.RequestOrder;
import com.foodcatalogue.order_service.dto.ResponseOrder;
import com.foodcatalogue.order_service.services.OrderService;


@RestController("/api/orders") 
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public List<ResponseOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/create")
    public ResponseOrder createOrder(@RequestBody @Validated RequestOrder orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @PatchMapping("/update/{id}")
    public ResponseOrder updateOrder(@PathVariable UUID id, @RequestBody @Validated RequestOrder orderRequest) {
        return orderService.updateOrder(id, orderRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable UUID id) {
        return orderService.deleteOrder(id);
    }

    @GetMapping("/user/{userId}")
    public List<ResponseOrder> getOrdersByUserId(@PathVariable UUID userId, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sortBy, @RequestParam(required = false) String sortOrder) {
        return orderService.getOrdersByUserId(userId, page, size, sortBy, sortOrder);
    }

}
