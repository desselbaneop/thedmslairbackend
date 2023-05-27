package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.ERole;
import com.ywa.thedmslairbackend.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
