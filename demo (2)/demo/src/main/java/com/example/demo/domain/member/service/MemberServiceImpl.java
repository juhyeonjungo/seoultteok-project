package com.example.demo.domain.member.service;

import com.example.demo.domain.member.dto.Member;
import com.example.demo.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public void registerMember(Member member) {
        memberMapper.insertMember(member);
    }

    @Override
    public Member findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }
}
