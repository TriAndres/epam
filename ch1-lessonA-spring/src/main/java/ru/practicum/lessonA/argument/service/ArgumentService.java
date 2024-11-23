package ru.practicum.lessonA.argument.service;
import ru.practicum.lessonA.argument.model.Argument;
import java.util.Collection;
import java.util.Optional;

public interface ArgumentService {
    Argument save(Argument argument);

    Optional<Argument> findById(long id);

    Collection<Argument> findAll();

    void deleteById(long id);
}
