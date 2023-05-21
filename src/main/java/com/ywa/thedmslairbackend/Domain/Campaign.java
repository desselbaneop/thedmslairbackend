package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Campaign")
public class Campaign {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "campaign_name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "Campaign_Characters",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "character_id") }
    )
    private Set<Character> characters = new HashSet<>();

    @ManyToMany(mappedBy = "campaignsParticipant")
    private Set<Player> players = new HashSet<>();

    @ManyToMany(mappedBy = "campaignAdmins")
    private Set<Player> admins = new HashSet<>();
}
