package ru.practicum.lessonA.model.lesson2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ArgumentRepository {
    private final Map<Long, Argument> argumentMap = new HashMap<>();

    public void create(Argument argument) {
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
