package ru.geekbrains.lessontwelve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lessontwelve.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
