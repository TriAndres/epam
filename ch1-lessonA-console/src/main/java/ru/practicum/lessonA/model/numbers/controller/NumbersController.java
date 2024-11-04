package ru.practicum.lessonA.model.numbers.controller;

import ru.practicum.lessonA.model.numbers.service.NumbersService;

public class NumbersController {

    public static NumbersService game() {
        return new NumbersService();
    }
}