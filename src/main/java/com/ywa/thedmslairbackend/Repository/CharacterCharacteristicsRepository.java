package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterCharacteristics;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterCharacteristicsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterCharacteristicsRepository extends JpaRepository<CharacterCharacteristics, CharacterCharacteristicsId> {
}
