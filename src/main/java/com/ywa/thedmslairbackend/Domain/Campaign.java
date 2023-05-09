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

    @ManyToMany(mappedBy = "campaignsParticipant")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "campaignAdmins")
    private Set<User> admins = new HashSet<>();
}
