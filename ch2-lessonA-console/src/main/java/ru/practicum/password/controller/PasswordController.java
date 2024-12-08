package ru.practicum.password.controller;

import ru.practicum.password.file.PasswordFile;
import ru.practicum.password.service.PasswordService;

import static ru.practicum.password.file.PasswordFile.loadFromFile;

public class PasswordController {
    private static final String file = "";
    private static final PasswordFile passwordFile = loadFromFile(file);

    public static PasswordService passwordService() {
        return new PasswordService(passwordFile);
    }
}
