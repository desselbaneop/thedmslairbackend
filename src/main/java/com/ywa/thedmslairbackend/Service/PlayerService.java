package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Player;
import com.ywa.thedmslairbackend.Domain.Role;
import com.ywa.thedmslairbackend.Repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Player findById(int playerId){
        return playerRepository.findById(playerId).orElseThrow(EntityNotFoundException::new);
    }

    public Player save(Player player){
        return playerRepository.save(player);
    }

    public void deleteById(int playerId){
        playerRepository.deleteById(playerId);
    }
}
