package ru.practicum.password.controller;

import ru.practicum.password.file.PasswordFile;
import ru.practicum.password.service.PasswordEmployee;
import ru.practicum.password.service.PasswordService;

import static ru.practicum.password.file.PasswordFile.loadFromFile;

public class PasswordController {
    private static final String file = "ch2-lessonA-console\\src\\main\\java\\ru\\practicum\\password\\file\\PasswordFile.txt";
    private static final PasswordFile passwordFile = loadFromFile(file);

    public static PasswordService passwordService() {
        return new PasswordService(passwordFile);
    }


    public static PasswordEmployee passwordEmployee() {
        return new PasswordEmployee(passwordFile);
    }

    public static PasswordFile passwordFile() {
        return passwordFile;
    }
}