package ru.geekbrains.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categories")
    Integer id;
    @Column(name = "category_name")
    String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<Product> products;
}
