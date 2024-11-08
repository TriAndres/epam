package ru.practicum.lessonA.model.argument.repo;

import ru.practicum.lessonA.model.argument.model.Argument;

import java.util.Collection;

public interface ArgumentRepository {
    Collection<Argument> getArgumentAll();

    void create(Argument argument);

    boolean containsKey(long id);

    Argument findById(long id);

    void deleteById(long id);
}
