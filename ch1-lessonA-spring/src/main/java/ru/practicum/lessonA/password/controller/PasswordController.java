package ru.practicum.lessonA.password.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.lessonA.password.model.Password;
import ru.practicum.lessonA.password.service.PasswordService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService service;

    @GetMapping
    public Collection<Password> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Password save(@RequestBody Password password) {
        return service.save(password);
    }

    @GetMapping
    public Optional<Password> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
