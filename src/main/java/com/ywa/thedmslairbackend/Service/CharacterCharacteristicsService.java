package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterCharacteristics;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterCharacteristicsId;
import com.ywa.thedmslairbackend.Repository.CharacterCharacteristicsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterCharacteristicsService {

    @Autowired
    CharacterCharacteristicsRepository characterCharacteristicsRepository;

    public List<CharacterCharacteristics> findAll(){
        return characterCharacteristicsRepository.findAll();
    }

    public CharacterCharacteristics findById(CharacterCharacteristicsId characterCharacteristicsId){
        return characterCharacteristicsRepository.findById(characterCharacteristicsId).orElseThrow(EntityNotFoundException::new);
    }

    public CharacterCharacteristics save(CharacterCharacteristics characterCharacteristics){
        return characterCharacteristicsRepository.save(characterCharacteristics);
    }

    public void deleteById(CharacterCharacteristicsId characterCharacteristicsId){
        characterCharacteristicsRepository.deleteById(characterCharacteristicsId);
    }
}
