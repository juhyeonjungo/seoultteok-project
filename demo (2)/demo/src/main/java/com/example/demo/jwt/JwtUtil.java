package com.example.demo.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secretKey = "mysecretkeymysecretkeymysecretkeymysecretkey";
    private final long expirationMs = 1000 * 60 * 60; // 1시간

    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes());

    // ✅ 토큰 생성
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ 토큰 유효성 검사 및 이메일 추출
    public String validateTokenAndGetEmail(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return claims.getBody().getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }
}
