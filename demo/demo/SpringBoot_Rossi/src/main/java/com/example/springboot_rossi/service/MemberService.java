package com.example.springboot_rossi.service;

import com.example.springboot_rossi.domain.Member;

import java.util.List;

public interface MemberService {
    public void save(Member member);

    public Member findById(Long id);
    public List<Member> findAll();
}