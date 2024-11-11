package ru.practicum.lessonA.model.password.repository;

import ru.practicum.lessonA.model.password.model.Password;

import java.util.Collection;

public interface PasswordRepository {

    Collection<Password> getByAll();

    Password create(Password password);

    boolean containsKey(long id);

    Password getById(long id);

    void deleteId(long id);

    void clear();
}
