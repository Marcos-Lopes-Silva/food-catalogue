package com.foodcatalogue.order_service.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor 
@NoArgsConstructor 
@Setter 
@Getter  
@Builder 
public class OrderItem {
    private UUID id;
    private String name;
    private Double price;
    private Integer quantity;

}
