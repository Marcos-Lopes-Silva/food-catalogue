package com.foodcatalogue.order_service.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodcatalogue.order_service.dto.RequestOrder;
import com.foodcatalogue.order_service.dto.ResponseOrder;
import com.foodcatalogue.order_service.services.OrderService;

@RestController 
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping 
    public List<ResponseOrder> getOrders() {
        return orderService.getOrders();
    }

    public ResponseOrder createOrder(@RequestBody @Validated RequestOrder orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    public ResponseOrder updateOrder(@RequestParam UUID id, @RequestBody @Validated RequestOrder orderRequest) {
        return orderService.updateOrder(id, orderRequest);
    }

    public String deleteOrder(@RequestParam UUID id) {
        return orderService.deleteOrder(id);
    }

}
