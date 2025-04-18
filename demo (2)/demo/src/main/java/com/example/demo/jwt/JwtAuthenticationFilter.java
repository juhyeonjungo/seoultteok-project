package com.example.demo.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    // 🔐 로그인 요청 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        try {
            // JSON 형태로 요청받은 email, password 꺼내기
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> requestBody = objectMapper.readValue(request.getInputStream(), Map.class);
            System.out.println("요청값: " + requestBody.get("email") + ", " + requestBody.get("password")); // ✅ 꼭 찍어봐라

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(requestBody.get("email"), requestBody.get("password"));

            // 인증 시도 (→ UserDetailsService를 내부적으로 호출함)
            //Spring Security는 authToken.getPrincipal()로 이메일을 꺼내서
            //→ 우리가 만든 CustomUserDetailsServiceImpl의 이 메서드를 호출
            // BCryptPasswordEncoder.matches()로  front에서 사용자 비밀번호와 db에 있는비밀번호 비교
            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ✅ 로그인 성공 시 실행됨
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
         //Authentication authResult :인증(로그인)이 성공한 사용자에 대한 인증된 정보 객체
        String email = authResult.getName(); // email 가져오기
        String token = jwtUtil.generateToken(email); // 토큰 발급

        response.setHeader("Authorization", "Bearer " + token);

        // 프론트로 JSON 응답
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        Map<String, String> body = new HashMap<>();
        body.put("token", token);

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
    }

    // ❌ 로그인 실패 시
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed)
            throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("로그인 실패: " + failed.getMessage());
    }
}
