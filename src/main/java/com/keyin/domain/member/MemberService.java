package com.keyin.domain.member;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member findMemberById(long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        return memberOptional.orElse(null);
    }

    public Member findMemberByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    public Member findMemberByPhoneNumber(String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    public Member findMemberByStartDate(LocalDate startDate) {
        return memberRepository.findByStartDate(startDate);
    }

    public void deleteMemberById(long id) {
        memberRepository.deleteById(id);
    }

    public Member updateMemberById(long id, Member updatedMember) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isPresent()) {
            Member memberToUpdate = memberOptional.get();
            memberToUpdate.setName(updatedMember.getName());
            memberToUpdate.setEmail(updatedMember.getEmail());
            memberToUpdate.setPhoneNumber(updatedMember.getPhoneNumber());
            memberToUpdate.setAddress(updatedMember.getAddress());
            memberToUpdate.setMembershipDuration(updatedMember.getMembershipDuration());
            memberToUpdate.setStartDate(updatedMember.getStartDate());

            return memberRepository.save(memberToUpdate);
        }

        return null;
    }

}
