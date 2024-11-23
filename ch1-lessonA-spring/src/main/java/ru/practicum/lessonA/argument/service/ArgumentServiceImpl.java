package ru.practicum.lessonA.argument.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.lessonA.argument.repository.ArgumentRepository;
import ru.practicum.lessonA.argument.model.Argument;
//import ru.practicum.lessonA.argument.repository.ArgumentRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArgumentServiceImpl implements ArgumentService{

    private final ArgumentRepository repository;

    public Argument save(Argument argument) {
        return repository.save(argument);
    }

    public Optional<Argument> findById(long id) {
        return repository.findById(id);
    }

    public Collection<Argument> findAll() {
        return repository.findAll();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}