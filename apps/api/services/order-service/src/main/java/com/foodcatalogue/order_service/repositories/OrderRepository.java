package com.foodcatalogue.order_service.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodcatalogue.order_service.models.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findByUserId(UUID userId, int page, int size, String sortBy, String sortOrder);
}
