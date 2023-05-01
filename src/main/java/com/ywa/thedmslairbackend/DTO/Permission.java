package com.ywa.thedmslairbackend.DTO;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Permission")
public class Permission {

    @Id
    @GeneratedValue
    private Integer permission_id;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> permissions = new ArrayList<>();

    private String permission_name;
}
