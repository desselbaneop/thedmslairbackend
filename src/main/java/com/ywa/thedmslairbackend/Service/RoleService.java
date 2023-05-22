package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Role;
import com.ywa.thedmslairbackend.Domain.Stat;
import com.ywa.thedmslairbackend.Repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role findById(int roleId){
        return roleRepository.findById(roleId).orElseThrow(EntityNotFoundException::new);
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public void deleteById(int roleId){
        roleRepository.deleteById(roleId);
    }
}
