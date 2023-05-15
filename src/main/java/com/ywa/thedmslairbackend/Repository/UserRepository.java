package com.ywa.thedmslairbackend.Repository;

import com.ywa.thedmslairbackend.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
