package ru.practicum.password.file;

import ru.practicum.password.model.Password;
import ru.practicum.password.repository.PasswordRepositoryImpl;

import java.util.List;

public class PasswordFile extends PasswordRepositoryImpl {
    private final String file;

    public PasswordFile(String file) {
        this.file = file;
    }

    public void saveF() {

    }

    @Override
    public List<Password> findAll() {
        return super.findAll();
    }

    @Override
    public Password save(Password password) {
        return super.save(password);
    }

    @Override
    public Boolean containsKey(long id) {
        return super.containsKey(id);
    }

    @Override
    public Password findById(long id) {
        return super.findById(id);
    }

    @Override
    public void deleteId(long id) {
        super.deleteId(id);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    public static PasswordFile loadFromFile(String file) {
        return null;
    }
}
