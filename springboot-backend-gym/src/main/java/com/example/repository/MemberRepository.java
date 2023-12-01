package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
