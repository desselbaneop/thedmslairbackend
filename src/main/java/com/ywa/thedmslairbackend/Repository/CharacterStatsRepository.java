package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.CharacterStats;
import com.ywa.thedmslairbackend.Domain.ManyToManyMappings.CharacterStatsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterStatsRepository extends JpaRepository<CharacterStats, CharacterStatsId> {
}
