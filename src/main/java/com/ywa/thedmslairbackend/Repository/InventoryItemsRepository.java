package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.InventoryItems;
import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.InventoryItemsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemsRepository extends JpaRepository<InventoryItems, InventoryItemsId> {
}
