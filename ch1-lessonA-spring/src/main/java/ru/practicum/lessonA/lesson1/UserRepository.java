package ru.practicum.lessonA.lesson1;

import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Long, User> userMap = new HashMap<>();

    public User createHello(User user) {
        user.setId(getNextId());
        userMap.put(user.getId(), user);
        return user;
    }

    public Collection<User> usersShowAll() {
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
