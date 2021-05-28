package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
