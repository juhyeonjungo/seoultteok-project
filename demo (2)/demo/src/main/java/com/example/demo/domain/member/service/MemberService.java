package com.example.demo.domain.member.service;

import com.example.demo.domain.member.dto.Member;

public interface MemberService {

    void registerMember(Member member);
    Member findByEmail(String email);
}
