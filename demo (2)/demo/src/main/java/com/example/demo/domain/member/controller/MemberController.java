package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.dto.Member;
import com.example.demo.domain.member.service.MemberService;
import com.example.demo.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Member member) {
        // 비밀번호 인코딩은 여기서 수행
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.registerMember(member);
        return ResponseEntity.ok("회원가입 성공");
    }
}
