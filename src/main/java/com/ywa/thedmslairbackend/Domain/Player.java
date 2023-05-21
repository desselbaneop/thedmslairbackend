package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue
    private Integer player_id;

    @Column(name = "username", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Players",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") }
    )
    Set<Campaign> campaignsParticipant = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Admins",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") }
    )
    Set<Campaign> campaignAdmins = new HashSet<>();

    @OneToMany(mappedBy = "player")
    private Set<Character> characters;
}
