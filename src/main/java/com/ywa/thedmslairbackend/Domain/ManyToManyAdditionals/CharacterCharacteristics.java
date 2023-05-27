package com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.Characteristic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Character_Characteristics")
@IdClass(CharacterCharacteristicsId.class)
public class CharacterCharacteristics {

    @Id
    @JsonBackReference(value = "character-characteristics")
    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @Id
    @GeneratedValue
    private Integer characteristicOwned;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "characteristic_id", referencedColumnName = "id")
    private Characteristic characteristic;

    @Column(nullable = false)
    private int value;
}
