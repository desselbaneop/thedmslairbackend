package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue
    private Integer role_id;

    @Column(name = "role_name", nullable = false)
    private String name;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "Role_Permissions",
            joinColumns = { @JoinColumn(name = "role_id")},
            inverseJoinColumns = { @JoinColumn(name = "permission_id")}
    )
    private Set<Permission> permissions = new HashSet<>();

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL
    )
    private Set<Player> players = new HashSet<>();

    public void addPermission(Permission permission) {
        permissions.add(permission);
        //TODO
        // - After creating a controller for permissions - add function
        // - example: https://github.com/refactorizando-web/Many-To-Many
    }
    public void removePermission(Permission permission) {
        permissions.remove(permission);
        //TODO
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
