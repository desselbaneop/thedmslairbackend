package com.ywa.thedmslairbackend.Service;

import com.ywa.thedmslairbackend.Domain.Permission;
import com.ywa.thedmslairbackend.Domain.Role;
import com.ywa.thedmslairbackend.Repository.PermissionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    public List<Permission> findAll(){
        return permissionRepository.findAll();
    }

    public Permission findById(int permissionId){
        return permissionRepository.findById(permissionId).orElseThrow(EntityNotFoundException::new);
    }

    public Permission save(Permission permission){
        return permissionRepository.save(permission);
    }

    public void deleteById(int permissionId){
        permissionRepository.deleteById(permissionId);
    }
}
