package com.example.bookstoreapi.security;

import com.example.bookstoreapi.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Component
public class JwtTokenService {

    private final String JWT_SECRET_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." + //header (alg, typ)
            "eyJ1c2VybmFtZSI6InJvb3QiLCJwYXNzd29yZCI6InJvb3QifQ." + //payload (data)
            "iORktWaxpg322KgQrZ1dOPNF7Ek6OWDk_L-ecm531WQ"; // verify signature (HS256)

    public String generateToken(User user) {
        Instant expirationTime = Instant.now().plus(1, ChronoUnit.HOURS);
        Date expirationDate = Date.from(expirationTime);

        Key key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes());

        String compactTokenString = Jwts.builder()
                .claim("id", user.getId())
                .claim("sub", user.getUsername())
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return "Bearer " + compactTokenString;
    }

    public UserPrincipal parseToken(String token) {
        byte[] secretBytes = JWT_SECRET_KEY.getBytes();

        Jws<Claims> jwsClaims = Jwts.parserBuilder()
                .setSigningKey(secretBytes)
                .build()
                .parseClaimsJws(token);

        String username = jwsClaims.getBody()
                .getSubject();
        Integer userId = jwsClaims.getBody()
                .get("id", Integer.class);

        return new UserPrincipal(userId, username);
    }
}
