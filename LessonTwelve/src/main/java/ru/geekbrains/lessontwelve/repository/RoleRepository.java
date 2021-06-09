package ru.geekbrains.lessontwelve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lessontwelve.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
