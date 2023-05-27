package com.ywa.thedmslairbackend.Service.ServicesImpl;

import com.ywa.thedmslairbackend.Domain.User;
import com.ywa.thedmslairbackend.Repository.UserRepository;
import com.ywa.thedmslairbackend.Service.Interfaces.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(int playerId){
        return userRepository.findById(playerId).orElseThrow(EntityNotFoundException::new);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteById(int playerId){
        userRepository.deleteById(playerId);
    }
}
