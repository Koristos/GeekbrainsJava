package ru.geekbrains.lessontwelve.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    int id;
    @Column(name = "product_name")
    String name;
    @Column(name = "product_price")
    int price;
    @Column(name = "creation_date")
    LocalDateTime creationDate;
    @Column(name = "update_date")
    LocalDateTime updateDate;
}
