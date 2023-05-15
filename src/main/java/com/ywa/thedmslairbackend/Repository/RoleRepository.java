package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
