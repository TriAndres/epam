package ru.practicum.lessonA.model.password.repository;

import ru.practicum.lessonA.model.password.model.Password;

public interface PasswordRepository {
    Password create(Password password);

    boolean containsKey(long id);

    Password getById(long id);

    void deleteId(long id);

    void clear();
}
