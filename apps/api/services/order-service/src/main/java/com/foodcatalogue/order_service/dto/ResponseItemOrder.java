package com.foodcatalogue.order_service.dto;

import java.math.BigDecimal;
import java.util.UUID;

import com.foodcatalogue.order_service.models.OrderItem;

public record ResponseItemOrder(UUID id, String name, BigDecimal price, Integer quantity) {

    public static ResponseItemOrder fromEntity(OrderItem itemOrder) {
        return new ResponseItemOrder(itemOrder.getId(), itemOrder.getName(), itemOrder.getPrice(),
                itemOrder.getQuantity());
    }
}
