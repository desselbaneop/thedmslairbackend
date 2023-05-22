package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Stat;
import com.ywa.thedmslairbackend.Repository.StatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StatService {

    @Autowired
    StatRepository statRepository;

    public List<Stat> findAll(){
        return statRepository.findAll();
    }

    public Stat findById(int statId){
        return statRepository.findById(statId).orElseThrow(EntityNotFoundException::new);
    }

    public Stat save(Stat stat){
        return statRepository.save(stat);
    }

    public void deleteById(int statId){
        statRepository.deleteById(statId);
    }
}
