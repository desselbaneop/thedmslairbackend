package com.ywa.thedmslairbackend.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

   /* @Id
    @GeneratedValue
    private Integer role_id;

    @Column(name = "role_name", nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "Role_Permissions",
            joinColumns = { @JoinColumn(name = "role_id")},
            inverseJoinColumns = { @JoinColumn(name = "permission_id")}
    )
    private Set<Permission> permissions = new HashSet<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL
    )
    private Set<User> users = new HashSet<>();*/

}
