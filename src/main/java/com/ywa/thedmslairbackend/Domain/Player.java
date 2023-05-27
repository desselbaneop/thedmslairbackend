package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "player_id")
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

    @JsonBackReference(value = "campaign-participants")
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Players",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") }
    )
    List<Campaign> campaignsParticipant;

    @JsonBackReference(value = "campaign-admins")
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Admins",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") }
    )
    List<Campaign> campaignAdmins;

    @JsonManagedReference(value = "player-characters")
    @OneToMany(mappedBy = "player")
    List<Character> characters;

}
