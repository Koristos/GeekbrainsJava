package ru.geekbrains.lessontwelve.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_items")
    int id;
    @Column(name = "purchase_price")
    int price;
    @Column(name = "item_number")
    int itemNumber;
    @ManyToOne
    @JoinColumn (name = "order_id", referencedColumnName = "id_orders")
    Order order;
    @ManyToOne
    @JoinColumn (name = "product_id", referencedColumnName = "id_products")
    Product product;
}
