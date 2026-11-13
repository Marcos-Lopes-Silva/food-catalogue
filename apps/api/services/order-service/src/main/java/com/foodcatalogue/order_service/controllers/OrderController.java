package com.foodcatalogue.order_service.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodcatalogue.order_service.dto.RequestOrder;
import com.foodcatalogue.order_service.dto.ResponseOrder;
import com.foodcatalogue.order_service.services.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'GESTOR')")
    public List<ResponseOrder> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/create")
    public ResponseOrder createOrder(@RequestBody @Validated RequestOrder orderRequest, @AuthenticationPrincipal Jwt jwt) {
        UUID userId = jwt != null ? UUID.fromString(jwt.getSubject()) : null;
        return orderService.createOrder(orderRequest, userId);
    }

    @PatchMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'GESTOR')")
    public ResponseOrder updateOrder(@PathVariable UUID id, @RequestBody @Validated RequestOrder orderRequest) {
        return orderService.updateOrder(id, orderRequest);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'GESTOR')")
    public String deleteOrder(@PathVariable UUID id) {
        return orderService.deleteOrder(id);
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'GESTOR') or #userId.toString() == authentication.name")
    public List<ResponseOrder> getOrdersByUserId(@PathVariable UUID userId, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sortBy, @RequestParam(required = false) String sortOrder) {
        return orderService.getOrdersByUserId(userId, page, size, sortBy, sortOrder);
    }

    @PostMapping("/{orderId}/repeat")
    public ResponseOrder repeatOrder(@PathVariable UUID orderId, @AuthenticationPrincipal Jwt jwt) {
        return orderService.repeatOrder(orderId, UUID.fromString(jwt.getSubject()));
    }

}
