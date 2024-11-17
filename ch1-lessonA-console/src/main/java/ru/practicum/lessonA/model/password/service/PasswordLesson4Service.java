package ru.practicum.lessonA.model.password.service;

import ru.practicum.lessonA.model.password.file.PasswordFile;
import ru.practicum.lessonA.model.password.model.Password;

import static ru.practicum.lessonA.console.Console.getString;
import static ru.practicum.lessonA.model.password.file.PasswordFile.loadFromFile;

public class PasswordLesson4Service {
    private final PasswordFile passwordFile;

    public PasswordLesson4Service(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public static void main(String[] args) {
        String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
        PasswordFile passwordFile = loadFromFile(file);
        PasswordLesson4Service pls = new PasswordLesson4Service(passwordFile);

        pls.lesson4();
    }

    /*
     4. Ввести пароль из командной строки и сравнить его со строкой-образцом.
     */
    public void lesson4() {
        System.out.println("Введите пароль:");
        boolean flag = false;
        String password = getString();
        for (Password passwords : passwordFile.getByAll()) {
            if (passwords.getPassword().equals(password)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Пароль в списке есть. ");
        } else {
            System.out.println("Пароля в списке нет. ");
        }
    }
}