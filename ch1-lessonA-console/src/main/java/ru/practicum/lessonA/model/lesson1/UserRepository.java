package ru.practicum.lessonA.model.lesson1;

import ru.practicum.lessonA.model.lesson2.Argument;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<Long, User> userMap = new HashMap<>();

    public void create(User user) {
        user.setId(getNextId());
        userMap.put(user.getId(), user);
    }

    public Collection<User> getUserAll() {
        return userMap.values();
    }

    private Long getNextId() {
        long currentMaxId = userMap.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
