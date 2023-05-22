package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterStats;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterStatsId;
import com.ywa.thedmslairbackend.Repository.CharacterStatsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterStatsService {

    @Autowired
    CharacterStatsRepository characterStatsRepository;

    public List<CharacterStats> findAll(){
        return characterStatsRepository.findAll();
    }

    public CharacterStats findById(CharacterStatsId characterStatsId){
        return characterStatsRepository.findById(characterStatsId).orElseThrow(EntityNotFoundException::new);
    }

    public CharacterStats save(CharacterStats characterStats){
        return characterStatsRepository.save(characterStats);
    }

    public void deleteById(CharacterStatsId characterStatsId){
        characterStatsRepository.deleteById(characterStatsId);
    }
}
