package ru.practicum.lessonA.model.numbers.repository;

import ru.practicum.lessonA.model.numbers.model.Numbers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NumbersRepository {
    private final Map<Long, Numbers> numbersMap = new HashMap<>();

    public Collection<Numbers> numberGetAll() {
        return numbersMap.values();
    }

    public void numberCreate(Numbers number) {
        number.setId(getNextId());
        numbersMap.put(number.getId(), number);
    }

    private long getNextId() {
        long currentMaxId = numbersMap.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}