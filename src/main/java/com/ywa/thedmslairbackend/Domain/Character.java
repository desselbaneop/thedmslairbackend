package com.ywa.thedmslairbackend.Domain;

import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.CharacterCharacteristics;
import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.CharacterStats;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Character")
public class Character {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;

    @OneToMany(mappedBy = "character")
    private Set<CharacterStats> stats;

    @OneToMany(mappedBy = "character")
    private Set<CharacterCharacteristics> characteristics;

    @ManyToMany(mappedBy = "characters")
    private Set<Campaign> campaigns = new HashSet<>();
}
