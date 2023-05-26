package com.ywa.thedmslairbackend.Controller;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.Player;
import com.ywa.thedmslairbackend.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    @GetMapping
    public ResponseEntity<List<Campaign>> findAll(){
        List<Campaign> campaigns = campaignService.findAll();
        if (!campaigns.isEmpty()){
            return new ResponseEntity<>(campaignService.findAll(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> findById(@PathVariable int id){
        Campaign campaign = campaignService.findById(id);
        if (campaign!=null){
            return new ResponseEntity<>(campaign, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Campaign(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<Player>> findPlayersByCampaignId(@PathVariable int id){
        List<Player> players = campaignService.findById(id).getPlayers();
        if (!players.isEmpty()){
            return new ResponseEntity<>(players, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/admins")
    public ResponseEntity<List<Player>> findAdminsByCampaignId(@PathVariable int id){
        List<Player> admins = campaignService.findById(id).getAdmins();
        if (!admins.isEmpty()){
            return new ResponseEntity<>(admins, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Campaign> create(@RequestBody Campaign campaign){
        return new ResponseEntity<>(campaignService.save(campaign), HttpStatus.OK);
    }

    @PostMapping("/{id}/admins")
    public ResponseEntity<Player> addAdmin(@PathVariable int id, @RequestBody int playerId){
        if (campaignService.findById(id)!=null){
            campaignService.addAdminByPlayerId(playerId, id);
            return new ResponseEntity<>(HttpStatus.OK);
            //TODO
            // UNDERSTAND WHY THIS DOES NOT WORK
//            return new ResponseEntity<>(campaignService.addAdminByPlayerId(playerId, id), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Campaign updateById(@RequestBody Campaign campaign){
        return campaignService.save(campaign);
    }

//    @PutMapping("/{id}/players")

}
