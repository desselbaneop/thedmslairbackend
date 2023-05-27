package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterCharacteristics;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "characters")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Character {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String backstory;
    private String imgURL;

    @JsonBackReference(value = "user-characters")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;

    @JsonManagedReference(value = "character-stats")
    @OneToMany(mappedBy = "character")
    private Set<CharacterStats> stats;

    @JsonManagedReference(value = "character-characteristics")
    @OneToMany(mappedBy = "character")
    private Set<CharacterCharacteristics> characteristics;

    @JsonBackReference(value = "campaign-characters")
    @ManyToMany(mappedBy = "characters")
    private Set<Campaign> campaigns = new HashSet<>();
}
