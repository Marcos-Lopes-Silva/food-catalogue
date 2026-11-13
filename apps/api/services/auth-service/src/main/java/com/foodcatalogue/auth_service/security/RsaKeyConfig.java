package com.foodcatalogue.auth_service.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;


@Configuration
public class RsaKeyConfig {

    private static final Logger log = LoggerFactory.getLogger(RsaKeyConfig.class);

    @Value ("${application.security.jwt.keystore-location:}")
    private String keystoreLocation;

    @Value("${application.security.jwt.keystore-password:}")
    private String keystorePassword;

    @Value("${application.security.jwt.key-alias:jwt-signing}")
    private String keyAlias;

    @Bean
    public KeyPair jwtKeyPair(ResourceLoader resourceLoader) throws Exception {
        if (!StringUtils.hasText(keystoreLocation)) {
            log.warn("application.security.jwt.keystore-location não configurado: usando chave RSA efêmera (apenas para desenvolvimento)");
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            return generator.generateKeyPair();
        }

        Resource keystore = resourceLoader.getResource(keystoreLocation);
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(keystore.getInputStream(), keystorePassword.toCharArray());

        RSAPrivateKey privateKey = (RSAPrivateKey) keyStore.getKey(keyAlias, keystorePassword.toCharArray());
        RSAPublicKey publicKey = (RSAPublicKey) keyStore.getCertificate(keyAlias).getPublicKey();

        return new KeyPair(publicKey, privateKey);
    }

    @Bean
    public RSAKey jwtPublicJwk(KeyPair jwtKeyPair) throws Exception {
        return new RSAKey.Builder((RSAPublicKey) jwtKeyPair.getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyIDFromThumbprint()
                .build();
    }
}
