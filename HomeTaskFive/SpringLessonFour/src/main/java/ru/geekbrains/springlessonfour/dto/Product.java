package ru.geekbrains.springlessonfour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="storage")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    @Column(name="prod_name")
    private String name;
    @Column(name="prod_desc")
    private String description;
    @Column(name="price")
    private Double price;

}


