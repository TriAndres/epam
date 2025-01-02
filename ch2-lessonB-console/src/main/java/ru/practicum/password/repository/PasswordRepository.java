package ru.practicum.password.repository;

import ru.practicum.password.model.Password;

import java.util.List;

public interface PasswordRepository {
    List<Password> findAll();
    Password save(Password password);
    Boolean containsKey(long id);
    Password findById(long id);
    void deleteId(long id);
    void deleteAll();
}