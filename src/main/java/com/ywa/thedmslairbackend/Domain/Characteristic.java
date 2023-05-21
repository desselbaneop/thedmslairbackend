package com.ywa.thedmslairbackend.Domain;

import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.CharacterCharacteristics;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Characteristic")
public class Characteristic {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "characteristic_name", nullable = false)
    private String characteristicName;

    @Column(name = "characteristic_description")
    private String characteristicDescription;

    @OneToMany(mappedBy = "characteristic")
    private Set<CharacterCharacteristics> characters;
}
