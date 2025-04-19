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

    public String validateTokenAndGetEmail(String token) {
        try {
            System.out.println("🔑 검증 중인 토큰: " + token);  // 디버깅용 로그 추가

            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token); // 👉 여기서 만료되었으면 예외 터짐

            String email = claims.getBody().getSubject();
            Date expiration = claims.getBody().getExpiration();
            System.out.println("✅ 유효한 토큰입니다. 사용자 이메일: " + email);
            System.out.println("⏳ 만료 시각: " + expiration);

            return email;
        } catch (ExpiredJwtException e) {
            System.out.println("❌ 토큰이 만료되었습니다. → 만료시각: " + e.getClaims().getExpiration());
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("❌ JWT 오류 발생: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        return null;
    }

}
