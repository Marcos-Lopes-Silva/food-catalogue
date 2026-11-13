package com.foodcatalogue.auth_service.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

@RestController
public class JwksController {

    private final RSAKey jwtPublicJwk;

    public JwksController(RSAKey jwtPublicJwk) {
        this.jwtPublicJwk = jwtPublicJwk;
    }

    @GetMapping ("/.well-known/jwks.json")
    public Map<String, Object> jwks() {
        return new JWKSet(jwtPublicJwk).toJSONObject();
    }
}
