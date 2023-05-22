package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterStats;
import com.ywa.thedmslairbackend.Domain.ManyToManyAdditionals.CharacterStatsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterStatsRepository extends JpaRepository<CharacterStats, CharacterStatsId> {
}
