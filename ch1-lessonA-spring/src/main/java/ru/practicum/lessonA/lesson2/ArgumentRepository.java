package ru.practicum.lessonA.lesson2;

import org.springframework.stereotype.Repository;
import ru.practicum.lessonA.lesson2.model.Argument;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ArgumentRepository {
    private final Map<Long, Argument> argumentMap = new HashMap<>();

    public Argument argumentCurrent(Argument argument) {
        argument.setId(getNextId());
        return argumentMap.put(argument.getId(), argument);
    }

    public Collection<Argument> argumentFindAll() {
        return argumentMap.values();
    }

    private long getNextId() {
        long currentMaxId = argumentMap.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}