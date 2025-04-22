package com.example.demo.jwt;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends GenericFilter {

    private final JwtUtil jwtUtil;
    //모든 API 요청은 여기로 걸림
    //- Authorization 헤더에서 JWT 꺼냄
    //- 토큰이 유효한지 확인 (JwtUtil.validateTokenAndGetEmail)
    //- 거기서 email, role 파싱
    //- 이 정보로 UsernamePasswordAuthenticationToken 만들어서
    //  👉 SecurityContextHolder 에 넣음 (→ Spring Security가 "인증된 사용자"로 처리함)

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        String authHeader = httpReq.getHeader("Authorization");

        try {
            if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7); // "Bearer " 제외

                // 유효성 검사 + 만료 체크
                String email = jwtUtil.validateTokenAndGetEmail(token);
                System.out.println("📌 validate 결과 이메일: " + email);

                String role = jwtUtil.getRoleFromToken(token); // ✅ 역할도 추출

                if (email != null && role != null) {
                    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(email, null, authorities);
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpReq));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

            chain.doFilter(request, response);

        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            httpRes.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpRes.getWriter().write("토큰이 만료되었습니다.");
        } catch (io.jsonwebtoken.JwtException e) {
            httpRes.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpRes.getWriter().write("유효하지 않은 토큰입니다.");
        } catch (Exception e) {
            // ⚠️ 핵심: 나머지 예외는 Spring에 던져서 500 오류 나오게 함
            throw e;
        }
    }
}
