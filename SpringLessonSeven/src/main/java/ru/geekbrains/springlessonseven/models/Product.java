package ru.geekbrains.springlessonseven.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private int price;
}
