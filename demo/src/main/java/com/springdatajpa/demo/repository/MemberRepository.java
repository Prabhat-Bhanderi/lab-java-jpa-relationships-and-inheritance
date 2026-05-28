package com.springdatajpa.demo.repository;

import com.springdatajpa.demo.model.nurse.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {}