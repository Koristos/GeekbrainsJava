package ru.geekbrains.springlessoneleven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springlessoneleven.models.Role;
import ru.geekbrains.springlessoneleven.models.User;

public interface RoleRepository extends JpaRepository <Role, Integer> {
}
