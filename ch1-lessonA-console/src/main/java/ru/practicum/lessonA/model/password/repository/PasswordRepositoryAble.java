package ru.practicum.lessonA.model.password.repository;

import ru.practicum.lessonA.model.password.model.Password;

import java.util.*;

public class PasswordRepositoryAble implements PasswordRepository {
    private final Map<Long, Password> passwordMap = new HashMap<>();

    @Override
    public Collection<Password> getByAll() {
        return new ArrayList<>(passwordMap.values());
    }

    @Override
    public Password create(Password password) {
        return passwordMap.put(password.getId(), password);
    }

    @Override
    public boolean containsKey(long id) {
        return passwordMap.containsKey(id);
    }

    @Override
    public Password getById(long id) {
        return passwordMap.get(id);
    }

    @Override
    public void deleteId(long id) {
        passwordMap.remove(id);
    }

    @Override
    public void clear() {
        passwordMap.clear();
    }
}