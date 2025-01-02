package ru.practicum.password.repository;

import ru.practicum.password.model.Password;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordRepositoryImpl implements PasswordRepository{
    private final Map<Long, Password> passwordMap = new HashMap<>();
    @Override
    public List<Password> findAll() {
        return List.of();
    }

    @Override
    public Password save(Password password) {
        return null;
    }

    @Override
    public Boolean containsKey(long id) {
        return null;
    }

    @Override
    public Password findById(long id) {
        return null;
    }

    @Override
    public void deleteId(long id) {

    }

    @Override
    public void deleteAll() {

    }
}
