package com.ywa.thedmslairbackend.Controller;

import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.Inventory;
import com.ywa.thedmslairbackend.Payload.Request.CharacterPostPutRequest;
import com.ywa.thedmslairbackend.Service.CharacterService;
import com.ywa.thedmslairbackend.Service.InventoryService;
import com.ywa.thedmslairbackend.Service.ServicesImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    UserServiceImpl userService;

    /**
     * This endpoint is not used right now.
     * In further iterations of the project will be used on the MODERATOR's dashboard to control the guidelines policies,
     * renaming or removing a Character.
     * @return either returns an notFound error or a list of Character objects
     */
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Character>> findAll(){
        List<Character> characters = characterService.findAll();
        if (!characters.isEmpty()){
            return new ResponseEntity<>(characters, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * This endpoint is currently used to show a particular character in case a user wants to modify it through the
     * Character component on the front-end
     * @param id is passed as a simple integer from the front
     * @return either returns an notFound error or a Character object
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Character> findById(@PathVariable int id){
        Character character = characterService.findById(id);
        if (character!=null){
            return new ResponseEntity<>(character, HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * This endpoint is used to create a Character & to assign it an inventory (as it's a one-to-one, it's done here)
     * @param characterSent is a custom form that uses the same args as Character, it's easier to send data from the front
     * @return either returns an notFound error or a Character object
     */
    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Character> create(@Valid @RequestBody CharacterPostPutRequest characterSent){
        System.out.println(characterSent);
        Inventory inventory = new Inventory();
        inventoryService.save(inventory);

        Character character = new Character();
        character.setName(characterSent.getName());
        character.setDescription(characterSent.getDescription());
        character.setBackstory(characterSent.getBackstory());
        character.setImgURL(characterSent.getImgURL());
        character.setInventory(inventory);
        character.setUser(userService.findById(characterSent.getUserId()));
        return new ResponseEntity<>(characterService.save(character), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Character> update(@PathVariable int id, @RequestBody Character characterSent){
        Character character = characterService.findById(id);
        if (character!=null){
            character.setName(characterSent.getName());
            character.setDescription(characterSent.getDescription());
            character.setBackstory(characterSent.getBackstory());
            character.setImgURL(characterSent.getImgURL());
            return new ResponseEntity<>(characterService.save(character), HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        if (characterService.findById(id)!=null){
            characterService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
