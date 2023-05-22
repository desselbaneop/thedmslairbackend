package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.InventoryItems;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.InventoryItemsId;
import com.ywa.thedmslairbackend.Repository.InventoryItemsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemsService {

    @Autowired
    InventoryItemsRepository inventoryItemsRepository;

    public List<InventoryItems> findAll(){
        return inventoryItemsRepository.findAll();
    }

    public InventoryItems findById(InventoryItemsId inventoryItemsId){
        return inventoryItemsRepository.findById(inventoryItemsId).orElseThrow(EntityNotFoundException::new);
    }

    public InventoryItems save(InventoryItems inventoryItems){
        return inventoryItemsRepository.save(inventoryItems);
    }

    public void deleteById(InventoryItemsId inventoryItemsId){
        inventoryItemsRepository.deleteById(inventoryItemsId);
    }
}
