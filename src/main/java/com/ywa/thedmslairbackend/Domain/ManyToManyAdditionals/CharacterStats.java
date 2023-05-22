package com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals;

import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.Stat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Character_Stats")
@IdClass(CharacterStatsId.class)
public class CharacterStats {

    @Id
    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @Id
    @GeneratedValue
    private Integer statOwned;

    @ManyToOne
    @JoinColumn(name = "stat_id", referencedColumnName = "id")
    private Stat stat;

    @Column(nullable = false)
    private int value;
}
