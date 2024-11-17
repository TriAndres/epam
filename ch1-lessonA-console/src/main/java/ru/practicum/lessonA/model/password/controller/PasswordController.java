package ru.practicum.lessonA.model.password.controller;

import ru.practicum.lessonA.model.password.file.PasswordFile;
import ru.practicum.lessonA.model.password.service.PasswordLesson4Service;
import ru.practicum.lessonA.model.password.service.PasswordService;

import static ru.practicum.lessonA.model.password.file.PasswordFile.loadFromFile;

public class PasswordController {
    private static final String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
    private static final PasswordFile passwordFile = loadFromFile(file);

    public static PasswordLesson4Service passwordLesson4() {
        return new PasswordLesson4Service(passwordFile);
    }

    public static PasswordService password() {
        return new PasswordService(passwordFile);
    }
}