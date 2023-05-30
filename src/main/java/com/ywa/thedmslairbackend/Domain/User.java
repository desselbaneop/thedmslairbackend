package com.ywa.thedmslairbackend.Domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ywa.thedmslairbackend.Domain.DeSerializers.User.UserDeserializer;
import com.ywa.thedmslairbackend.Domain.DeSerializers.User.UserSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonDeserialize(using = UserDeserializer.class)
@JsonSerialize(using = UserSerializer.class)
@Entity
@Getter
@Setter
@Table( name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Email(message = "Invalid email format")
    @Column(nullable = false, length = 75)
    private String email;

    @JsonIgnore
    @Column(nullable = false, length = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @JsonIdentityReference(alwaysAsId = true)
    @JsonBackReference(value = "campaign-participants")
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Users",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "campaign_id") }
    )
    List<Campaign> campaignsParticipant;

    @JsonIdentityReference(alwaysAsId = true)
    @JsonBackReference(value = "campaign-admins")
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Campaign_Admins",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "campaign_id") }
    )
    List<Campaign> campaignAdmins;

    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference(value = "user-characters")
    @OneToMany(mappedBy = "user")
    List<Character> characters;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

}
