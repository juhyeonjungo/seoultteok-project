package com.example.demo.jwt;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Collections;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends GenericFilter {

    private final JwtUtil jwtUtil;

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

                if (email != null) {
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
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
