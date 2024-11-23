package ru.practicum.lessonA.argument.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.lessonA.argument.model.Argument;
import ru.practicum.lessonA.argument.service.ArgumentServiceImpl;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/argument")
public class ArgumentController {

    private final ArgumentServiceImpl argumentService;

    @GetMapping
    public Collection<Argument> findAll() {
        return argumentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Argument save(@RequestBody Argument argument) {
        return argumentService.save(argument);
    }

    @GetMapping("/{id}")
    public Optional<Argument> findById(@PathVariable long id) {
        return argumentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        argumentService.deleteById(id);
    }
}
