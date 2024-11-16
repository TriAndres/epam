package test.lesson2;

import org.springframework.stereotype.Repository;
import test.lesson2.model.Lesson2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Lesson2Repository {
    private final Map<Long, Lesson2> argumentMap = new HashMap<>();

    public Lesson2 lesson2Current(Lesson2 lesson2) {
        lesson2.setId(getNextId());
        argumentMap.put(lesson2.getId(), lesson2);
        return lesson2;
    }

    public Collection<Lesson2> lesson2FindAll() {
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