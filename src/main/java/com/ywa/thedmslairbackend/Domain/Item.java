package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @OneToMany(mappedBy = "item")
    private Set<Inventory> inventorySet;
}
