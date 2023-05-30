package com.ywa.thedmslairbackend.Controller;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.User;
import com.ywa.thedmslairbackend.Service.Interfaces.UserService;
import com.ywa.thedmslairbackend.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    /**
     * This endpoint is not used right now.
     * In further iterations of the project will be used on the MODERATOR's dashboard for role&permission granting,
     * banning and removing users the accounts.
     * @return either returns an notFound error or a list of User objects
     */
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if (!users.isEmpty()){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * The endpoint is currently only used to get the user's information for further parsing in UserProfile component
     * @param id is passed as a simple integer from the front
     * @return either returns an notFound error or a User object
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        User user = userService.findById(id);
        if (user !=null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * The endpoint is currently used to show the user's characters in UserProfile component and to add a character
     * to an existing campaign through the Campaign component
     * @param id is passed as a simple integer from the front
     * @return either returns an notFound error or a list of Character objects
     */
    @GetMapping("/{id}/characters")
    public ResponseEntity<List<Character>> findPlayersCharactersByPlayerId(@PathVariable int id){
        List<Character> characters = userService.findById(id).getCharacters();
        if (!characters.isEmpty()){
            return new ResponseEntity<>(characters, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * The endpoint is only used to show the user's campaigns in UserProfile
     * @param id is passed as a simple integer from the front
     * @return either returns an notFound error or a list of Campaign objects
     */
    @GetMapping("/{id}/campaigns")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Campaign>> findCampaignsOfPlayerByPlayerId(@PathVariable int id){
        List<Campaign> campaigns = userService.findById(id).getCampaignsParticipant();
        if (!campaigns.isEmpty()){
            return new ResponseEntity<>(campaigns, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * The endpoint is currently used to modify the User's data except for the
     * @param id is passed as a simple integer from the front
     * @return either returns an notFound error or a User object
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User userSent){
        User user = userService.findById(id);
        if (user !=null){
            user.setUsername(userSent.getUsername());
            user.setEmail(userSent.getEmail());
            user.setPassword(userSent.getPassword());
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * The endpoint is not used right now. Would allow the MODERATORs to delete the user's account completely
     * @param id is passed as a simple integer from the front
     * @return either returns an notFound error or OK HttpStatus
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        if (userService.findById(id)!=null){
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
