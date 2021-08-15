package ru.geekbrains.springlessonfour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Entity
    @Table(name="orders")
    public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_orders")
        private Integer id;
        @Column(name="cart_id")
        private String cartId;
        @Column(name="id_products")
        private Integer prodictId;

}
