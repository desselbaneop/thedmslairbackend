package com.ywa.thedmslairbackend.Controller;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.User;
import com.ywa.thedmslairbackend.Service.CampaignService;
import com.ywa.thedmslairbackend.Service.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;
    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Campaign>> findAll(){
        List<Campaign> campaigns = campaignService.findAll();
        if (campaigns.isEmpty()){
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(campaignService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Campaign> findById(@PathVariable int id){
        Campaign campaign = campaignService.findById(id);
        if (campaign==null){
            return ResponseEntity.notFound().build();
        }else {
            return new ResponseEntity<>(campaign, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/users")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<User>> findPlayersByCampaignId(@PathVariable int id){
        List<User> users = campaignService.findById(id).getUsers();
        if (!users.isEmpty()){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // TODO:
    //  Left this out for the further development. Not needed right now
    //  The endpoint would allow to get all the custom "admins" of a campaign. Look further for the usage of "admins"
/*    @GetMapping("/{id}/admins")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<User>> findAdminsByCampaignId(@PathVariable int id){
        List<User> admins = campaignService.findById(id).getAdmins();
        if (!admins.isEmpty()){
            return new ResponseEntity<>(admins, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @PostMapping()
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Campaign> create(@RequestBody Campaign campaignSent){
        Campaign campaign = new Campaign(campaignSent.getName(), campaignSent.getDescription());
        campaignService.save(campaign);
        return new ResponseEntity<>(campaign, HttpStatus.CREATED);
    }

    // TODO:
    //  Left this out for the further development. Not needed right now
    //  The endpoint would allow to add custom "admins" to the campaign
    //  That would give the added admins the ability to modify the campaign, add other players to it, etc.

/*    @PostMapping("/{id}/admins")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> addAdmin(@PathVariable int id, @RequestParam("playerId") int playerId){
        if (campaignService.findById(id)!=null){
            campaignService.addAdminByPlayerId(playerId, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping("/{id}/users")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> addPlayer(@PathVariable int id, @RequestParam("playerId") int playerId){
        if (campaignService.findById(id)!=null){
            campaignService.addPlayerByPlayerId(playerId, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Campaign> updateCampaignById(@PathVariable int id, @RequestBody Campaign campaignSent){
        System.out.println(campaignSent);
        Campaign campaign = campaignService.findById(id);
        campaign.setName(campaignSent.getName());
        campaign.setDescription(campaignSent.getDescription());
        System.out.println(campaign);
        return new ResponseEntity<>(campaignService.save(campaign), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteCampaignById(@PathVariable int id){
        if (campaignService.findById(id)!=null){
            campaignService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{campaignId}/users/{playerId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> removePlayerFromCampaignByIds(@PathVariable int campaignId, @PathVariable int playerId){
        if (campaignService.findById(campaignId)!=null&& userService.findById(playerId)!=null){
            campaignService.removePlayerFromCampaignByIds(campaignId, playerId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // TODO:
    //  Left this out for the further development. Not needed right now
    //  The endpoint would allow the "owner" of the campaign to delete the custom "admins" from it
/*    @DeleteMapping("/{campaignId}/admins/{adminId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> removeAdminFromCampaignByIds(@PathVariable int campaignId, @PathVariable int adminId){
        if (campaignService.findById(campaignId)!=null&& userService.findById(adminId)!=null){
            campaignService.removeAdminFromCampaignByIds(campaignId, adminId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

}
