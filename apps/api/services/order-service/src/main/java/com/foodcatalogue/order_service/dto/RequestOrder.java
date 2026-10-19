package com.foodcatalogue.order_service.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;

import lombok.Builder;

@Builder 
public record RequestOrder(@NotNull UUID id, @NotNull String customerName, @NotNull String customerTel, @NotNull BigDecimal totalPrice, @NotNull List<RequestItemOrder> items) {
    
}
