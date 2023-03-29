package com.example.n_plus_1.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name ="TEAM_ID")
    private Team team;

    public Member(String name) {
        this.name = name;


    }


    public Member() {

    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
