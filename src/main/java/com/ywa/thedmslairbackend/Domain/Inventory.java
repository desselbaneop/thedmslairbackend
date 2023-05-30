package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.InventoryItems;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "inventory")
    private Character character;

    @JsonIgnore
    @OneToMany(mappedBy = "inventory")
    private Set<InventoryItems> items;

    public Inventory() {
    }
}
