package com.foodcatalogue.auth_service.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token) {
    
}
