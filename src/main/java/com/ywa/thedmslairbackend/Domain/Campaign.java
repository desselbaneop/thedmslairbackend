package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Campaign")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Campaign implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "campaign_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "Campaign_Characters",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "character_id") }
    )
    private List<Character> characters;

    @JsonManagedReference
    @ManyToMany(mappedBy = "campaignsParticipant")
    @Column(nullable = false)
    private List<Player> players = new ArrayList<>();

    @JsonManagedReference
    @ManyToMany(mappedBy = "campaignAdmins")
    private List<Player> admins = new ArrayList<>();

}
