package ru.practicum.lessonA.model.password.controller;

import ru.practicum.lessonA.model.password.file.PasswordFile;
import ru.practicum.lessonA.model.password.service.PasswordLesson4Service;
import ru.practicum.lessonA.model.password.service.PasswordLesson6Service;
import ru.practicum.lessonA.model.password.service.PasswordService;

import static ru.practicum.lessonA.model.password.file.PasswordFile.loadFromFile;

public class PasswordController {
    private static final String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
    private static final PasswordFile passwordFile = loadFromFile(file);

    public static PasswordFile password() {
        return passwordFile;
    }

    public static PasswordService passwordService() {
        return new PasswordService(passwordFile);
    }

    public static PasswordLesson4Service passwordLesson4() {
        return new PasswordLesson4Service(passwordFile);
    }

    public static PasswordLesson6Service passwordLesson6() {
        return new PasswordLesson6Service(passwordFile);
    }
}