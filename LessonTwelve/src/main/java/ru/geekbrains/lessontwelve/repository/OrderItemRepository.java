package ru.geekbrains.lessontwelve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lessontwelve.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
