package ru.practicum.password.repository;

import ru.practicum.password.model.Password;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordRepositoryImpl implements PasswordRepository{
    private final Map<Long, Password> passwordMap = new HashMap<>();

    @Override
    public List<Password> findAll() {
        return new ArrayList<>(passwordMap.values());
    }

    @Override
    public Password save(Password password) {
        return passwordMap.put(password.getId(), password);
    }

    @Override
    public boolean containsKey(long id) {
        return passwordMap.containsKey(id);
    }

    @Override
    public Password findById(long id) {
        return passwordMap.get(id);
    }

    @Override
    public void deleteId(long id) {
        passwordMap.remove(id);
    }

    @Override
    public void deleteAll() {
        passwordMap.clear();
    }
}