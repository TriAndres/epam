package ru.practicum.lessonA.model.argument.repo;

import ru.practicum.lessonA.model.argument.model.Argument;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArgumentRepositoryAble implements ArgumentRepository{
    private final Map<Long, Argument> argumentMap = new HashMap<>();

    @Override
    public Collection<Argument> getArgumentAll() {
        return argumentMap.values();
    }

    @Override
    public void create(Argument argument) {
        argumentMap.put(argument.getId(), argument);
    }

    @Override
    public boolean containsKey(long id) {
        return argumentMap.containsKey(id);
    }

    @Override
    public Argument findById(long id) {
        return argumentMap.get(id);
    }

    @Override
    public void deleteById(long id) {
        argumentMap.remove(id);
    }
}