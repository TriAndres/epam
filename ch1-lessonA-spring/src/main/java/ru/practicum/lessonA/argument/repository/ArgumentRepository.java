package ru.practicum.lessonA.argument.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.lessonA.argument.model.Argument;

public interface ArgumentRepository extends JpaRepository<Argument, Long> {
}