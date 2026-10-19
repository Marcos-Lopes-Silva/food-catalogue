package com.foodcatalogue.order_service.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Order {
    private UUID id;
    private String customerName;
    private String customerTel;
    private BigDecimal totalPrice;
    private List<OrderItem> items;

    public void updateDetails(String customerName, String customerTel, BigDecimal totalPrice,
            List<OrderItem> newItems) {
        this.customerName = customerName;
        this.customerTel = customerTel;
        this.totalPrice = totalPrice;

        this.items.clear();
        this.items.addAll(newItems);
    }
}
