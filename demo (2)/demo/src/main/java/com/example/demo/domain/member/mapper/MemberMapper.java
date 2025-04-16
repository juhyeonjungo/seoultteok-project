package com.example.demo.domain.member.mapper;

import com.example.demo.domain.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
    Member findByEmail(String email);
}
