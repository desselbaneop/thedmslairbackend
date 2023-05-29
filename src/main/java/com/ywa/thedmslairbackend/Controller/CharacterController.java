package com.ywa.thedmslairbackend.Controller;

import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Service.CharacterService;
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

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Character> create(@RequestBody Character characterSent){
        Character character = new Character();
        character.setName(characterSent.getName());
        character.setDescription(characterSent.getDescription());
        character.setBackstory(characterSent.getBackstory());
        character.setImgURL(characterSent.getImgURL());
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
