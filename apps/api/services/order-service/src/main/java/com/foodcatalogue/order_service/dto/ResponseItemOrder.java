package com.foodcatalogue.order_service.dto;

import java.util.UUID;

public record ResponseItemOrder(UUID id, String name, Double price, Integer quantity) {

    public static ResponseItemOrder fromEntity(com.foodcatalogue.order_service.models.OrderItem itemOrder) {
        return new ResponseItemOrder(itemOrder.getId(), itemOrder.getName(), itemOrder.getPrice(),
                itemOrder.getQuantity());
    }
}
