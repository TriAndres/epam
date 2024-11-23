package ru.practicum.lessonA.numbers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.lessonA.numbers.model.Numbers;
import ru.practicum.lessonA.numbers.service.NumbersService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/numbers")
@RequiredArgsConstructor
public class NumbersController {

    private final NumbersService service;
    @GetMapping
    public Collection<Numbers> findAll() {
        return service.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Numbers save(@RequestBody Numbers numbers) {
        return service.save(numbers);
    }
    @GetMapping("/{id}")
    public Optional<Numbers> findById(@PathVariable long id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
