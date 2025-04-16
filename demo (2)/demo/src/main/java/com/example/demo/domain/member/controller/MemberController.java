package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.dto.Member;
import com.example.demo.domain.member.mapper.MemberMapper;
import com.example.demo.domain.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Map;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.registerMember(member);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginInfo, HttpSession session) {
        Member user = memberService.findByEmail(loginInfo.get("email"));
        if (user == null || !passwordEncoder.matches(loginInfo.get("password"), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
        session.setAttribute("LOGIN_USER", user);
        return ResponseEntity.ok(user);
    }
}

