package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Inventory;
import com.ywa.thedmslairbackend.Domain.Item;
import com.ywa.thedmslairbackend.Repository.InventoryRepository;
import com.ywa.thedmslairbackend.Repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> findAll(){
        return inventoryRepository.findAll();
    }

    public Inventory findById(int inventoryId){
        return inventoryRepository.findById(inventoryId).orElseThrow(EntityNotFoundException::new);
    }

    public Inventory save(Inventory inventory){
        System.out.println(inventory);
        return inventoryRepository.save(inventory);
    }

    public void deleteById(int inventoryId){
        inventoryRepository.deleteById(inventoryId);
    }
}
