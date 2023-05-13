package com.ywa.thedmslairbackend.Domain.ManyToManyMappings;

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
    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @Id
    @GeneratedValue
    private Integer statOwned;

    @ManyToOne
    @JoinColumn(name = "characteristic_id", referencedColumnName = "id")
    private Characteristic characteristic;

    @Column(nullable = false)
    private int value;
}
