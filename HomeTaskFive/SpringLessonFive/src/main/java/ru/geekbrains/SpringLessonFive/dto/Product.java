package ru.geekbrains.SpringLessonFive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_product")
private Long id;
@Column(name = "product_title")
private String title;
@Column(name = "product_price")
private int price;
}
