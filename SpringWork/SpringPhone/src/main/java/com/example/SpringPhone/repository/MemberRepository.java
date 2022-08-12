package com.example.SpringPhone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringPhone.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
