package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer role_id;

    @Column(name = "role_name", nullable = false)
    private String name;

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
