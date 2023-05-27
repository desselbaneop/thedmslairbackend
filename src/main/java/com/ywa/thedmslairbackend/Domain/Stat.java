package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "stats")
public class Stat {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "stat_name")
    private String statName;

    @Column(name = "stat_description")
    private String statDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "stat")
    private Set<CharacterStats> characters;
}
