package ru.practicum.lessonA.model.argument.controller;

import ru.practicum.lessonA.model.argument.service.ArgumentService;

public class ArgumentController {

    public static ArgumentService argument() {
        return  new ArgumentService();
    }
}
