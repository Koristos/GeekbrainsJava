package ru.geekbrains.springlessoneleven.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.springlessoneleven.models.Score;
import ru.geekbrains.springlessoneleven.models.User;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
}
