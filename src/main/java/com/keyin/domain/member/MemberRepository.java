package com.keyin.domain.member;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface MemberRepository extends CrudRepository<Member, Long> {
    public Member findByNameContainingIgnoreCase(String name);
    public Member findByPhoneNumber(String phoneNumber);
    public Member findByStartDate(LocalDate startDate);
}
