package ru.practicum.lessonA.password.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.lessonA.password.model.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {
}