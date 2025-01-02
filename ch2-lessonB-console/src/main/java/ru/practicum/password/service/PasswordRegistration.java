package ru.practicum.password.service;

import ru.practicum.password.file.PasswordFile;

public class PasswordRegistration {
    private final PasswordFile passwordFile;

    public PasswordRegistration(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }
}
