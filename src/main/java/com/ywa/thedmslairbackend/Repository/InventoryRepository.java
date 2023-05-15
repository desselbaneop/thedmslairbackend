package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
