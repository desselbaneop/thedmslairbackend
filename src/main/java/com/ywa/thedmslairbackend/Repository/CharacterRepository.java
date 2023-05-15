package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
