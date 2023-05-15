package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
