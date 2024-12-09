package ru.practicum.password.service;

import ru.practicum.password.file.PasswordFile;
import ru.practicum.password.model.Password;

import java.util.List;

import static ru.practicum.console.Console.getString;

public class PasswordService {
    private final PasswordFile passwordFile;
    private String login;
    private String password;
    private Password pp;

    public PasswordService(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    //В приведенных ниже заданиях необходимо вывести внизу фамилию разра-
    //ботчика, дату и время получения задания, а также дату и время сдачи задания.
    //Добавить комментарии в программы в виде /** комментарий */. В заданиях на
    //числа объект можно создавать в виде массива символов.
    //Ввести n чисел с консоли.

    public List<Password> findAll() {
        return passwordFile.findAll();
    }
    public void registration() {
        int lengthRegistration = 4;
        System.out.println("Введите логин (или 0 для выхода)");
        while (true) {
            login = getString();
            if (login.length() > lengthRegistration) {
                break;
            }
            System.out.println("Длина логина должна больше " + lengthRegistration + " символов");
        }
        for (Password password : passwordFile.findAll()) {
            if (!password.getLogin().equals(login)) {
                break;
            } else if ("0".equals(login)) {
                break;
            }
        }

        if (!login.equals("0")) {
            System.out.println("Введите пароль:");
            while (true) {
                password = getString();
                if (password.length() > lengthRegistration) {
                    break;
                }
                System.out.println("Длина пароля должна больше " + lengthRegistration + " символов");
            }
            pp = new Password(login, password);
            pp.setId(getNextId());
            pp.setRegistration(true);
            passwordFile.save(pp);
            System.out.println("Логин и пароль записан.");
        } else {
            System.out.println("Существует логин.");
        }

    }

    public void entrance() {
        System.out.println("Введите логинн:");
        login = getString();
        for (Password password1 : passwordFile.findAll()) {
            if (password1.getLogin().equals(login)) {
                System.out.println("Логин верно ввели.\nВведите пароль:");
                password = getString();
                if (password1.getPassword().equals(password)) {
                    System.out.println("Пароль ввели верно.");
                    pp = password1;
                    pp.setRegistration(true);
                    passwordFile.save(pp);
                    break;
                } else {
                    System.out.println("Пароль введён неверно.");
                    break;
                }
            } else {
                System.out.println("Логин введён неверно.");
                break;
            }
        }
    }

    public Long getNextId() {
        long currentMaxId = passwordFile.findAll()
                .stream()
                .mapToLong(Password::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
