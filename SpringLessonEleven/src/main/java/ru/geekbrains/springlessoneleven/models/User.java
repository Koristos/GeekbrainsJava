package ru.geekbrains.springlessoneleven.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_password")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_users", referencedColumnName = "user_id")
    private Score score;
}
