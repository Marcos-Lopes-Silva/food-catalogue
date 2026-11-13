package com.foodcatalogue.auth_service.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.foodcatalogue.auth_service.models.User;
import com.nimbusds.jose.jwk.RSAKey;

import io.jsonwebtoken.Jwts;

import java.security.KeyPair;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private final KeyPair keyPair;
    private final String keyId;

    @Value("${application.security.jwt.expiration:86400000}")
    private long jwtExpiration;

    public JwtTokenProvider(KeyPair keyPair, RSAKey jwtPublicJwk) {
        this.keyPair = keyPair;
        this.keyId = jwtPublicJwk.getKeyID();
    }

    public String generateToken(User user) {
        List<String> roles = user.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .toList();

        return Jwts.builder()
                .subject(user.getId().toString())
                .claim("email", user.getEmail())
                .claim("name", user.getName())
                .claim("roles", roles)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .header().add("kid", keyId).and()
                .signWith(keyPair.getPrivate(), Jwts.SIG.RS256)
                .compact();
    }

}
