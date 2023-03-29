package com.example.n_plus_1;


import com.example.n_plus_1.entity.Member;
import com.example.n_plus_1.entity.Team;
import com.example.n_plus_1.repository.MemberRepository;
import com.example.n_plus_1.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
public class JpaTestCode {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        System.out.println("================Start Setup================");
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            members.add(new Member("member" + i));
        }
        memberRepository.saveAll(members);


        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Team team = new Team("team" + i);
            team.setMembers(members);
            teams.add(team);
        }
        teamRepository.saveAll(teams);

        entityManager.flush();
        entityManager.clear();
        System.out.println("================End Setup================");
    }

    @Test
    public void test() {

        System.out.println("================Start Test================");
        List<Team> all = teamRepository.findAll();
        System.out.println("================End Test================");

        System.out.println("================Start Test================");
        List<String> memberNames =
                all.stream().flatMap(it -> it.getMembers().stream()
                        .map(member -> member.getName())).collect(Collectors.toList());
        System.out.println("================End Test================");
    }
}
