package com.priyanshuRaj.taskmanager.security;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
    private final String JwtSecret = "a_very_long_and_secure_base64_encoded_secret_key_for_your_jwt_signing_algorithm_at_least_32_bytes";

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() ))
                .signWith(getSigningKey())
                .compact();
    }
    
}
