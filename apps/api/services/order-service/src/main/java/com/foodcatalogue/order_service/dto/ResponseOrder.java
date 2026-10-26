package com.foodcatalogue.order_service.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.foodcatalogue.order_service.models.Order;

import lombok.Builder;

@Builder 
public record ResponseOrder(UUID id, String customerName, String customerTel, BigDecimal totalPrice, List<ResponseItemOrder> items) {
    public static ResponseOrder fromEntity(Order order) {
        List<ResponseItemOrder> items = order.getItems().stream()
                .map(ResponseItemOrder::fromEntity)
                .collect(Collectors.toList());
        return new ResponseOrder(order.getId(), order.getCustomerName(), order.getCustomerTel(), order.getTotalPrice(), items);
    }
}
