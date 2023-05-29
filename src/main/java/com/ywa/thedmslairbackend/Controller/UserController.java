package com.ywa.thedmslairbackend.Controller;

import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.User;
import com.ywa.thedmslairbackend.Service.Interfaces.UserService;
import com.ywa.thedmslairbackend.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if (!users.isEmpty()){
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        User user = userService.findById(id);
        if (user !=null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/characters")
    public ResponseEntity<List<Character>> findPlayersCharactersByPlayerId(@PathVariable int id){
        List<Character> characters = userService.findById(id).getCharacters();
        if (!characters.isEmpty()){
            return new ResponseEntity<>(characters, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/campaigns")
    public ResponseEntity<List<Campaign>> findCampaignsOfPlayerByPlayerId(@PathVariable int id){
        List<Campaign> campaigns = userService.findById(id).getCampaignsParticipant();
        if (!campaigns.isEmpty()){
            return new ResponseEntity<>(campaigns, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userSent){
        User user = new User();
        user.setUsername(userSent.getUsername());
        user.setEmail(userSent.getEmail());
        user.setPassword(userSent.getPassword());
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        if (userService.findById(id)!=null){
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
