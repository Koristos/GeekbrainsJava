package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.geekbrains.models.Product;


public interface ProductRepo extends JpaRepository<Product, Integer>, JpaSpecificationExecutor {
}
