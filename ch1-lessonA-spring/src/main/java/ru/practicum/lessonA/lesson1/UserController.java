package ru.practicum.lessonA.lesson1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/hello")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createHello(@RequestBody User user) {
        return userService.createHello(user);
    }

    @GetMapping
    private Collection<User> usersShowAll() {
        return userService.usersShowAll();
    }
}