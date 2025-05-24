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
    private final String JwtSecret = "e8502bcab5f1093dff4b3c08e2b5bef2cf72895fadb4fb3e808a131271bdcc2dcc9a49e2d0583cf5c9504570db1cb14e73900f211b5b36b6ad1ff31d48f140f1";

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
