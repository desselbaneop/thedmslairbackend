package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {
}
