package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.InventoryItems;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "inventory")
    private Character character;

    @JsonIgnore
    @OneToMany(mappedBy = "inventory")
    private Set<InventoryItems> items;
}
