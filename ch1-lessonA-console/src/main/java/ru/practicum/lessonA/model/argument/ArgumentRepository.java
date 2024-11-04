package ru.practicum.lessonA.model.argument;

import ru.practicum.lessonA.model.lesson2.Argument;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArgumentRepository {
    private final Map<Long, ru.practicum.lessonA.model.lesson2.Argument> argumentMap = new HashMap<>();

    public void create(ru.practicum.lessonA.model.lesson2.Argument argument) {
        argument.setId(getNextId());
        argumentMap.put(argument.getId(), argument);
    }

    public Collection<Argument> getArgumentAll() {
       return argumentMap.values();
    }

    private Long getNextId() {
        long currentMaxId = argumentMap.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
