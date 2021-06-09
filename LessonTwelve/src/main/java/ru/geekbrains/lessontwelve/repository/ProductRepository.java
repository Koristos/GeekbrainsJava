package ru.geekbrains.lessontwelve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lessontwelve.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
