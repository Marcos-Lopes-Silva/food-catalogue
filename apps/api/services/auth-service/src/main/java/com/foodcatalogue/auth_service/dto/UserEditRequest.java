package com.foodcatalogue.auth_service.dto;

import com.foodcatalogue.auth_service.models.Role;

public record UserEditRequest(String email, String name, String password, Role role) {
} 
