package com.ywa.thedmslairbackend.DTO;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue
    private Integer role_id;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "Role_Permissions",
            joinColumns = { @JoinColumn(name = "role_id")},
            inverseJoinColumns = { @JoinColumn(name = "permission_id")}
    )
    private List<Permission> permissions = new ArrayList<>();

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL
    )
    private List<User> users = new ArrayList<>();

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
