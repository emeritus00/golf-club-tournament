package com.keyin.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    @GetMapping("/members/{id}")
    public Member getMemberByID(@PathVariable long id) {
        return memberService.findMemberById(id);
    }

    @GetMapping("/members/name/{name}")
    public Member getMemberByName(@PathVariable String name) {
        return memberService.findMemberByName(name);
    }

    @GetMapping("/members/phone/{phoneNumber}")
    public Member getMemberByPhoneNumber(@PathVariable String phoneNumber) {
        return memberService.findMemberByPhoneNumber(phoneNumber);
    }

    @GetMapping("/members/date/{startDate}")
    public Member getMemberByStartDAte(@PathVariable String startDate) {
        return memberService.findMemberByStartDate(LocalDate.parse(startDate));
    }

    @PostMapping("/member")
    public Member createMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @PutMapping("/members/{id}")
    public Member updateMember(@PathVariable long id, @RequestBody Member updatedMember) {
        return memberService.updateMemberById(id, updatedMember);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable long id) {memberService.deleteMemberById(id);
    }
}
