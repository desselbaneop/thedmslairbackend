package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
