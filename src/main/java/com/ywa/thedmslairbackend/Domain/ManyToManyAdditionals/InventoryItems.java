package com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals;

import com.ywa.thedmslairbackend.Domain.Inventory;
import com.ywa.thedmslairbackend.Domain.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Inventory_Items")
@IdClass(InventoryItemsId.class)
public class InventoryItems {

    @Id
    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;

    @Id
    @GeneratedValue
    private Integer itemOwned;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @Column(nullable = false)
    private int quantity;
}
