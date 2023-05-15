package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.CharacterCharacteristics;
import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.CharacterCharacteristicsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterCharacteristicsRepository extends JpaRepository<CharacterCharacteristics, CharacterCharacteristicsId> {
}
