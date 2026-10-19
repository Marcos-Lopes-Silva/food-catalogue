package com.foodcatalogue.order_service.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.foodcatalogue.order_service.dto.RequestOrder;
import com.foodcatalogue.order_service.dto.ResponseOrder;
import com.foodcatalogue.order_service.models.Order;
import com.foodcatalogue.order_service.models.OrderItem;
import com.foodcatalogue.order_service.repositories.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<ResponseOrder> getOrders() {
        var orders = this.orderRepository.findAll();

        return orders.stream()
                .map(ResponseOrder::fromEntity)
                .collect(Collectors.toList());
    }

    public ResponseOrder createOrder(RequestOrder orderRequest) {

        var order = Order.builder()
                .customerName(orderRequest.customerName())
                .customerTel(orderRequest.customerTel())
                .totalPrice(orderRequest.totalPrice())
                .build();

        this.orderRepository.save(order);

        return ResponseOrder.fromEntity(order);
    }

    public ResponseOrder updateOrder(UUID id, RequestOrder orderRequest) {
        var order = this.orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado."));

        List<OrderItem> newItems = orderRequest.items().stream()
                .map(item -> item.toEntity(order))
                .toList();

        order.updateDetails(
                orderRequest.customerName(),
                orderRequest.customerTel(),
                orderRequest.totalPrice(),
                newItems);

        this.orderRepository.save(order);

        return ResponseOrder.fromEntity(order);
    }

    public String deleteOrder(UUID id) {
        this.orderRepository.deleteById(id);
        return "Order deleted successfully";
    }

}
