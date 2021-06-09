package ru.geekbrains.lessontwelve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lessontwelve.models.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

UserProfile findUserProfileByName(String name);

}
