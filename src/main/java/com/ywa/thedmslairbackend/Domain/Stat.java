package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Stat")
public class Stat {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "stat_name")
    private String statName;

    @Column(name = "stat_description")
    private String statDescription;

    @OneToMany(mappedBy = "stat")
    private Set<Character> characters;
}
