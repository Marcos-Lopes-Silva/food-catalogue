package com.foodcatalogue.order_service.dto;

import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import com.foodcatalogue.order_service.models.OrderItem;
import com.foodcatalogue.order_service.models.Order;

import lombok.Builder;

@Builder
public record RequestItemOrder(@NotNull UUID id, @NotNull String name, @NotNull Double price,
        @NotNull Integer quantity) {

    public OrderItem toEntity(Order o) {
        return OrderItem.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .quantity(this.quantity)
                .build();
    }

}
