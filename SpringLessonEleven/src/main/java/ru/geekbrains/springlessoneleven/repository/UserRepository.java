package ru.geekbrains.springlessoneleven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springlessoneleven.models.User;

public interface UserRepository extends JpaRepository <User, Integer> {

    public User findUserByName(String name);
}
