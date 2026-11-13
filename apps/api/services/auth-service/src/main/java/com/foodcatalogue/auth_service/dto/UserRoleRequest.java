package com.foodcatalogue.auth_service.dto;

import com.foodcatalogue.auth_service.models.Role;

import jakarta.validation.constraints.NotNull;

public record UserRoleRequest(@NotNull Role role) {
}
