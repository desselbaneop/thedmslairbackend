package com.ywa.thedmslairbackend.Domain;

import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.InventoryItems;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "inventory")
    private Character character;

    @OneToMany(mappedBy = "inventory")
    private Set<InventoryItems> items;
}
