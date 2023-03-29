package com.example.n_plus_1.entity;


import lombok.Getter;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<>();


    public Team(String name) {
        this.name = name;
    }

    public Team() {

    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
