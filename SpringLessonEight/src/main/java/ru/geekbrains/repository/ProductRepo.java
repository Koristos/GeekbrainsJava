package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.models.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
