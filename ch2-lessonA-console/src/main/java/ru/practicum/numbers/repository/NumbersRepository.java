package ru.practicum.numbers.repository;

import ru.practicum.numbers.model.Numbers;

import java.util.List;

public interface NumbersRepository {
    List<Numbers> findAll();

    Numbers save(Numbers numbers);

    boolean containsKey(long id);

    Numbers findById(long id);

    void deleteById(long id);

    void deleteAll();
}