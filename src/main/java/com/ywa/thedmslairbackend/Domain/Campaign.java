package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Campaign implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "campaign_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @JsonManagedReference(value = "campaign-characters")
    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "Campaign_Characters",
            joinColumns = { @JoinColumn(name = "campaign_id") },
            inverseJoinColumns = { @JoinColumn(name = "character_id") }
    )
    private List<Character> characters;

    @JsonManagedReference(value = "campaign-participants")
    @ManyToMany(mappedBy = "campaignsParticipant")
//    @Column(nullable = false)
    private List<Player> players = new ArrayList<>();

    @JsonManagedReference(value = "campaign-admins")
    @ManyToMany(mappedBy = "campaignAdmins")
    private List<Player> admins = new ArrayList<>();

    public Campaign(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Campaign() {

    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", characters=" + characters +
                ", players=" + players +
                ", admins=" + admins +
                '}';
    }
}
