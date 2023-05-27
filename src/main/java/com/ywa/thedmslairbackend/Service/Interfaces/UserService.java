package com.ywa.thedmslairbackend.Service.Interfaces;

import com.ywa.thedmslairbackend.Domain.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface UserService {

    List<User> findAll() throws EntityNotFoundException;

    User findById(int playerId) throws EntityNotFoundException;

    User save(User user) throws EntityNotFoundException;

    void deleteById(int playerId) throws EntityNotFoundException;

}
