package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Permission")
public class Permission {

    @Id
    @GeneratedValue
    private Integer permission_id;

    @Column(name = "permission_name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "permissions")
    private List<Role> permissions = new ArrayList<>();

}
