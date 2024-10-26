package ru.practicum.lessonA.model.lesson2;

public class ArgumentController {
    private final ArgumentService argumentService;

    public ArgumentController() {
        argumentService = new ArgumentService();
    }

    public ArgumentService argument() {
        return argumentService;
    }
}