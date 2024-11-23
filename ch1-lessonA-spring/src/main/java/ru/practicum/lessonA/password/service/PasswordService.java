package ru.practicum.lessonA.password.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.lessonA.password.model.Password;
import ru.practicum.lessonA.password.repository.PasswordRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordRepository repository;

    public Collection<Password> findAll() {
        return repository.findAll();
    }

    public Password save(Password password) {
        return repository.save(password);
    }

    public Optional<Password> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
