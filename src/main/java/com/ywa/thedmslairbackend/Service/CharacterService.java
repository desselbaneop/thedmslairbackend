package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.Characteristic;
import com.ywa.thedmslairbackend.Repository.CharacterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public List<Character> findAll(){
        return characterRepository.findAll();
    }

    public Character findById(int characterId){
        return characterRepository.findById(characterId).orElseThrow(EntityNotFoundException::new);
    }

    public Character save(Character character){
        return characterRepository.save(character);
    }

    public void deleteById(int characterId){
        characterRepository.deleteById(characterId);
    }
}
