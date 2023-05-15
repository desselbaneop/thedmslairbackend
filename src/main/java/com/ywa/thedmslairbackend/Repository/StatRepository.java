package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Integer> {
}
