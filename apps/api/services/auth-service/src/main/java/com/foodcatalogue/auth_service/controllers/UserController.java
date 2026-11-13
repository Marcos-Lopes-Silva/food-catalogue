package com.foodcatalogue.auth_service.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;

import com.foodcatalogue.auth_service.dto.UserEditRequest;
import com.foodcatalogue.auth_service.dto.UserRequest;
import com.foodcatalogue.auth_service.dto.UserResponse;
import com.foodcatalogue.auth_service.dto.UserRoleRequest;
import com.foodcatalogue.auth_service.services.UserService;


@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> userResponse = this.userService.findAllUsers();
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = this.userService.registerUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(Authentication authentication) {
        UserResponse userResponse = this.userService.getUser(UUID.fromString(authentication.getName()));
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id.toString() == authentication.name")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        UserResponse userResponse = this.userService.getUser(id);
        return ResponseEntity.ok(userResponse);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or #id.toString() == authentication.name")
    public ResponseEntity<UserResponse> editUser(@PathVariable UUID id, @Valid @RequestBody UserEditRequest userEditRequest) {
        UserResponse userResponse = this.userService.editUser(id, userEditRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PatchMapping("/{id}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> editUserRole(@PathVariable UUID id, @Valid @RequestBody UserRoleRequest userRoleRequest) {
        UserResponse userResponse = this.userService.editUserRole(id, userRoleRequest.role());
        return ResponseEntity.ok(userResponse);
    }

}
