package com.keyin.domain;

import com.keyin.domain.member.Member;
import com.keyin.domain.member.MemberRepository;
import com.keyin.domain.tournament.Tournament;
import com.keyin.domain.tournament.TournamentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TournamentApplicationTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Test
    @Transactional
    void testCreateMember() {
        Member member = new Member();
        member.setName("John Doe");
        member.setEmail("john@example.com");
        member.setPhoneNumber("1234567890");
        member.setStartDate(LocalDate.now());
        member.setMembershipDuration(12);

        Member savedMember = memberRepository.save(member);
        assertThat(savedMember.getId()).isNotNull();
    }

    @Test
    @Transactional
    void testCreateTournamentAndAddMember() {
        // Create and save a member with required fields
        Member member = new Member();
        member.setName("Test Member");
        member.setEmail("test@example.com");
        member.setPhoneNumber("9876543210");
        member.setStartDate(LocalDate.now());
        member.setMembershipDuration(12);
        Member savedMember = memberRepository.save(member);

        // Create and save a tournament
        Tournament tournament = new Tournament();
        tournament.setStartDate(LocalDate.now());
        tournament.setEndDate(LocalDate.now().plusDays(2));
        tournament.setLocation("New York");
        tournament.setEntryFee(100.0);
        tournament.setCashPrizeAmount(1000.00);
        Tournament savedTournament = tournamentRepository.save(tournament);

        // Add member to tournament
        savedTournament.getParticipatingMembers().add(savedMember);
        tournamentRepository.save(savedTournament);

        // Retrieve and verify
        Tournament retrieved = tournamentRepository.findById(savedTournament.getId())
                .orElseThrow(() -> new RuntimeException("Tournament not found"));
        assertThat(retrieved.getParticipatingMembers()).hasSize(1);
        assertThat(retrieved.getParticipatingMembers()).contains(savedMember);
    }
}
