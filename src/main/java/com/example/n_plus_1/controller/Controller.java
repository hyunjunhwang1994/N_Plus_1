package com.example.n_plus_1.controller;

import com.example.n_plus_1.entity.Member;
import com.example.n_plus_1.entity.Team;
import com.example.n_plus_1.repository.MemberRepository;
import com.example.n_plus_1.repository.TeamRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;


    @GetMapping("/test")
    @Transactional
    public void testController () {
        List<Member> members = new ArrayList<>();

        Member member = new Member("testMember");
        Team team = new Team("testTeam");
        members.add(member);

        team.setMembers(members);
        member.setTeam(team);

        teamRepository.save(team);
        memberRepository.save(member);


    }

    @GetMapping("/test2")
    public void test2() {
        teamRepository.findAll();
    }


}
