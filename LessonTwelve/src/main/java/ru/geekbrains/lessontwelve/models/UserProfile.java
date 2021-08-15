package ru.geekbrains.lessontwelve.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_profiles")
    int id;
    @Column(name = "user_name")
    String name;
    @Column(name = "user_password")
    String password;
    @Column (name = "user_phone")
    int phone;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_profiles_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id"))
    List<Role> roles;
}
