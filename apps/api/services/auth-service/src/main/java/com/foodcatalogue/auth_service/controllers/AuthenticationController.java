package com.foodcatalogue.auth_service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodcatalogue.auth_service.dto.AuthenticationRequest;
import com.foodcatalogue.auth_service.dto.AuthenticationResponse;
import com.foodcatalogue.auth_service.services.AuthenticationService;

import jakarta.validation.Valid;

@RequestMapping("/auth")
@RestController 
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request.email(), request.password()));
    }

}
