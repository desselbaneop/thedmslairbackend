package com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class CharacterCharacteristicsId implements Serializable {
    private int character;
    private int characteristicOwned;
}
