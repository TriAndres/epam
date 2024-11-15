package ru.practicum.lessonA.model.password.service;

import ru.practicum.lessonA.model.password.file.PasswordFile;
import ru.practicum.lessonA.model.password.model.Password;

import static ru.practicum.lessonA.methods.console.Console.getString;
import static ru.practicum.lessonA.model.password.file.PasswordFile.loadFromFile;

public class PasswordLessonService {
    private final PasswordFile passwordFile;

    public PasswordLessonService(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public static void main(String[] args) {
        String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
        PasswordFile passwordFile = loadFromFile(file);
        PasswordLessonService pls = new PasswordLessonService(passwordFile);

        pls.lesson4();
    }

    /*
     4. Ввести пароль из командной строки и сравнить его со строкой-образцом.
     */
    public void lesson4() {
        String logins;
        String password;
        int id = 1;
        int passwordLength = 4;
        System.out.println("Введите логин:");
        while (true) {
            logins = getString();
            boolean flag = true;
            for (Password password1 : passwordFile.getByAll()) {
                if (password1.getLogin().equals(logins)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                break;
            }
            System.out.println("Существует логин, введите новый.");
        }
        System.out.println("Введите пароль:");
        while (true) {
            password = getString();
            if (password.length() > passwordLength) {
                break;
            }
            System.out.println("Длина пароля должна больше " + passwordLength + " символов");
        }
        Password pp = new Password(logins, password);
        pp.setId(getNextId());
        passwordFile.create(pp);
        System.out.println("Логин и пароль записан.");
    }

    /*
     6. Вывести фамилию разработчика, дату и время получения задания, а также
    дату и время сдачи задания.
     */
    public void lesson6() {

    }

    private long getNextId() {
        long currentMaxId = passwordFile.getByAll()
                .stream()
                .mapToLong(Password::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
