package com.ywa.thedmslairbackend.Domain.ManyToManyMappings;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class InventoryItemsId implements Serializable {

    private int inventory;
    private int itemOwned;
}
