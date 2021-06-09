package ru.geekbrains.lessontwelve.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders")
    int id;
    @ManyToOne
            @JoinColumn (name = "user_id", referencedColumnName = "id_user_profiles")
    UserProfile userProfile;
}
