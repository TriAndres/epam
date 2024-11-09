package ru.practicum.lessonA.model.numbers.repository;

import ru.practicum.lessonA.model.numbers.model.Numbers;

import java.util.Collection;

public interface NumbersRepository {
    Collection<Numbers> numberGetAll();

    Numbers numberCreate(Numbers number);

    boolean containsKey(long id);

    Numbers findById(long id);

    void deleteId(long id);

    void clear();
}