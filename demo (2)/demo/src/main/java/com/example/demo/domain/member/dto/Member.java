package com.example.demo.domain.member.dto;

import lombok.Data;

@Data
public class Member {
    private Long memberId;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String role;
    private String createdAt;
    private String birth;
    private String address;
}
