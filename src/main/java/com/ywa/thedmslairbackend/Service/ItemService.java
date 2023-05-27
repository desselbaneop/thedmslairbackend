package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Item;
import com.ywa.thedmslairbackend.Repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Item findById(int itemId){
        return itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public void deleteById(int itemId){
        itemRepository.deleteById(itemId);
    }
}
