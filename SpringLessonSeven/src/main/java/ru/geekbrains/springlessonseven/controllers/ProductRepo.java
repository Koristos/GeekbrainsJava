package ru.geekbrains.springlessonseven.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springlessonseven.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository <Product, Integer> {
    Optional<Product> findByName (String name);
    List<Product> findAllByPriceGreaterThanOrderByPrice (int min);
    List<Product> findAllByPriceLessThanOrderByPrice (int max);
    @Query ("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductBetween (int min, int max);
}
