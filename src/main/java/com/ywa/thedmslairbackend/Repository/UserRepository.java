package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Player, Integer> {
}
