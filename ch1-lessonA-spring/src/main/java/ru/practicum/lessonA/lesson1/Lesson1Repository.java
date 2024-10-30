package ru.practicum.lessonA.lesson1;

import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Lesson1Repository {
    private final Map<Long, Lesson1> userMap = new HashMap<>();

    public Lesson1 lesson1Create(Lesson1 user) {
        user.setId(getNextId());
        userMap.put(user.getId(), user);
        return user;
    }

    public Collection<Lesson1> lesson1ShowAll() {
        return userMap.values();
    }

    private Long getNextId() {
        long currentMaxId  = userMap.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0);
        return ++currentMaxId ;
    }

}
