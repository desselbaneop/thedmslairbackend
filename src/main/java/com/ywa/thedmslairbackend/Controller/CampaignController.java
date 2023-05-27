package com.ywa.thedmslairbackend.Controller;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.Player;
import com.ywa.thedmslairbackend.Service.CampaignService;
import com.ywa.thedmslairbackend.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;
    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Campaign>> findAll(){
        List<Campaign> campaigns = campaignService.findAll();
        if (campaigns.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(campaignService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Campaign> findById(@PathVariable int id){
        Campaign campaign = campaignService.findById(id);
        if (campaign==null){
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(campaign, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<Player>> findPlayersByCampaignId(@PathVariable int id){
        List<Player> players = campaignService.findById(id).getPlayers();
        if (!players.isEmpty()){
            return new ResponseEntity<>(players, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/admins")
    public ResponseEntity<List<Player>> findAdminsByCampaignId(@PathVariable int id){
        List<Player> admins = campaignService.findById(id).getAdmins();
        if (!admins.isEmpty()){
            return new ResponseEntity<>(admins, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Campaign> create(@RequestBody Campaign campaignSent){
        System.out.println(campaignSent);
        Campaign campaign = new Campaign(campaignSent.getName(), campaignSent.getDescription());
        System.out.println(campaign);
        campaignService.save(campaign);
        return new ResponseEntity<>(campaignService.save(campaign), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/admins")
    public ResponseEntity<Player> addAdmin(@PathVariable int id, @RequestParam("playerId") int playerId){
        if (campaignService.findById(id)!=null){
            campaignService.addAdminByPlayerId(playerId, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/players")
    public ResponseEntity<Player> addPlayer(@PathVariable int id, @RequestParam("playerId") int playerId){
        if (campaignService.findById(id)!=null){
            campaignService.addPlayerByPlayerId(playerId, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaignById(@PathVariable int id, @RequestBody Campaign campaignSent){
        System.out.println(campaignSent);
        Campaign campaign = campaignService.findById(id);
        campaign.setName(campaignSent.getName());
        campaign.setDescription(campaignSent.getDescription());
        System.out.println(campaign);
        return new ResponseEntity<>(campaignService.save(campaign), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCampaignById(@PathVariable int id){
        if (campaignService.findById(id)!=null){
            campaignService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{campaignId}/players/{playerId}")
    public ResponseEntity<HttpStatus> removePlayerFromCampaignByIds(@PathVariable int campaignId, @PathVariable int playerId){
        if (campaignService.findById(campaignId)!=null&&playerService.findById(playerId)!=null){
            campaignService.removePlayerFromCampaignByIds(campaignId, playerId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{campaignId}/admins/{adminId}")
    public ResponseEntity<HttpStatus> removeAdminFromCampaignByIds(@PathVariable int campaignId, @PathVariable int adminId){
        if (campaignService.findById(campaignId)!=null&&playerService.findById(adminId)!=null){
            campaignService.removeAdminFromCampaignByIds(campaignId, adminId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
