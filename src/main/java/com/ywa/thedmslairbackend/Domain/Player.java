package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player implements Serializable {

    @Id
    @GeneratedValue
    private Integer player_id;

    @Column(name = "username", nullable = false)
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Players",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") }
    )
    List<Campaign> campaignsParticipant;

    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Admins",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") }
    )
    List<Campaign> campaignAdmins;

    @JsonManagedReference
    @OneToMany(mappedBy = "player")
    List<Character> characters;

}
