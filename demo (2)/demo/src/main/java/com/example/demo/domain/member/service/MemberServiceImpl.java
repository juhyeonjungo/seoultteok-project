package com.example.demo.domain.member.service;

import com.example.demo.domain.member.dto.Member;
import com.example.demo.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerMember(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberMapper.insertMember(member);
    }

    @Override
    public Member findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }
}