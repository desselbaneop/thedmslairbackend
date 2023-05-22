package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Characteristic;
import com.ywa.thedmslairbackend.Domain.Inventory;
import com.ywa.thedmslairbackend.Repository.CharacteristicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacteristicService {

    @Autowired
    CharacteristicRepository characteristicRepository;

    public List<Characteristic> findAll(){
        return characteristicRepository.findAll();
    }

    public Characteristic findById(int characteristicId){
        return characteristicRepository.findById(characteristicId).orElseThrow(EntityNotFoundException::new);
    }

    public Characteristic save(Characteristic characteristic){
        return characteristicRepository.save(characteristic);
    }

    public void deleteById(int characteristicId){
        characteristicRepository.deleteById(characteristicId);
    }
}
