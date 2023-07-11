package com.example.springboot_rossi.repository;

import com.example.springboot_rossi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}