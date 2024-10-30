package ru.practicum.lessonA.lesson1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/lesson1")
@RestController
@RequiredArgsConstructor
public class Lesson1Controller {
    private final Lesson1Service userService;

    @PostMapping
    public Lesson1 lesson1Create(@RequestBody Lesson1 user) {
        return userService.lesson1Create(user);
    }

    @GetMapping
    private Collection<Lesson1> lesson1ShowAll() {
        return userService.lesson1ShowAll();
    }
}