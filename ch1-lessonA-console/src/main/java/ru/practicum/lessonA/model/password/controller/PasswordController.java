package ru.practicum.lessonA.model.password.controller;

import ru.practicum.lessonA.model.password.file.PasswordFile;
import ru.practicum.lessonA.model.password.service.PasswordLessonService;

import static ru.practicum.lessonA.model.password.file.PasswordFile.loadFromFile;

public class PasswordController {
    private static final String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
    private static final PasswordFile passwordFile = loadFromFile(file);

    public static PasswordLessonService passwordLesson() {
        return new PasswordLessonService(passwordFile);
    }
}