package com.foodcatalogue.auth_service.dto;

import jakarta.validation.constraints.Email;

public record UserEditRequest(@Email String email, String name) {
} 
