package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.Player;
import com.ywa.thedmslairbackend.Repository.CampaignRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    public List<Campaign> findAll(){
        return campaignRepository.findAll();
    }

    public Campaign findById(int campaignId){
        return campaignRepository.findById(campaignId).orElseThrow(EntityNotFoundException::new);
    }

    public Campaign save(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public ResponseEntity<List<Player>> addPlayerByPlayerId(int playerId, int campaignId){
        return campaignRepository.addPlayerByPlayerId(playerId, campaignId);
    }

    public ResponseEntity<Player> addAdminByPlayerId(int playerId, int campaignId){
        return campaignRepository.addAdminByPlayerId(playerId, campaignId);
    }

    public void deleteById(int campaignId){
        campaignRepository.deleteById(campaignId);
    }
}
