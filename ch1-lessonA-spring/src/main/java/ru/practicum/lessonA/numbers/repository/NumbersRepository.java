package ru.practicum.lessonA.numbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.lessonA.numbers.model.Numbers;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Long> {
}
