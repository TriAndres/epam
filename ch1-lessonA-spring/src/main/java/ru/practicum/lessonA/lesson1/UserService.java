package ru.practicum.lessonA.lesson1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createHello(User user) {
        user.setName(user.getName() + ", Вас приветствую!");
        userRepository.createHello(user);
        return user;
    }

    Collection<User> usersShowAll() {
        return userRepository.usersShowAll();
    }
}