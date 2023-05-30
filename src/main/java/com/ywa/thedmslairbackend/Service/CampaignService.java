package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Repository.CampaignRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Campaign findByName(String campaignName){
        return campaignRepository.findCampaignByName(campaignName);
    }

    public Campaign save(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public void addPlayerByPlayerId(int playerId, int campaignId){
        if (campaignRepository.checkDuplicates(playerId, campaignId)<1){
            campaignRepository.addPlayerByPlayerId(playerId, campaignId);
        }else {
            System.out.println("Exists");
        }
    }

    public void addAdminByPlayerId(int playerId, int campaignId){
        campaignRepository.addAdminByPlayerId(playerId, campaignId);
    }

    public void deleteById(int campaignId){
        campaignRepository.deleteById(campaignId);
    }

    public void removePlayerFromCampaignByIds(int campaignId, int playerId) {
        campaignRepository.removePlayerFromCampaignByIds(campaignId, playerId);
    }
    public void removeAdminFromCampaignByIds(int campaignId, int adminId) {
        campaignRepository.removeAdminFromCampaignByIds(campaignId, adminId);
    }
}
