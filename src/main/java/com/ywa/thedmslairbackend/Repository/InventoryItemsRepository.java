package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.InventoryItems;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.InventoryItemsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemsRepository extends JpaRepository<InventoryItems, InventoryItemsId> {
}
