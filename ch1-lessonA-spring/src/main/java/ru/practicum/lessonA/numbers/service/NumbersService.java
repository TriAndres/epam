package ru.practicum.lessonA.numbers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.lessonA.numbers.model.Numbers;
import ru.practicum.lessonA.numbers.repository.NumbersRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NumbersService {
    private final NumbersRepository repository;

    public Collection<Numbers> findAll() {
       return repository.findAll();
    }

    public Numbers save(Numbers numbers) {
        return repository.save(numbers);
    }

    public Optional<Numbers> findById(long id) {
        return repository.findById(id);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}