package test.lesson1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class Lesson1Service {
    private final Lesson1Repository userRepository;
/*
1. Приветствовать любого пользователя при вводе его имени через команд-
ную строку.
 */
    public Lesson1 lesson1Create(Lesson1 user) {
        user.setName(user.getName() + ", Вас приветствую!");
        userRepository.lesson1Create(user);
        return user;
    }

    Collection<Lesson1> lesson1ShowAll() {
        return userRepository.lesson1ShowAll();
    }
}