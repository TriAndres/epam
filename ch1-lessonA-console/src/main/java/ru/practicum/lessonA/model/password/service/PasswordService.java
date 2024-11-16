package ru.practicum.lessonA.model.password.service;

import ru.practicum.lessonA.model.password.file.PasswordFile;
import ru.practicum.lessonA.model.password.model.Password;

import java.util.Collection;

import static ru.practicum.lessonA.console.Console.getString;

public class PasswordService {
    private final PasswordFile passwordFile;
    private String logins;

    private String password;
    private Password pp;
    private final Collection<Password> passwords;

    public PasswordService(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
        passwords = passwordFile.getByAll();
    }

//    public static void main(String[] args) {
//        String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
//        PasswordFile passwordFile = loadFromFile(file);
//        PasswordService pls = new PasswordService(passwordFile);
//
//        System.out.println(pls.registration().getRegistration());
//        ;
//    }

    public Password registration() {
        boolean flag;
        int passwordLength = 4;
        System.out.println("Введите логин:");
        do {
            logins = getString();
            flag = true;
            for (Password password1 : passwords) {
                if (password1.getLogin().equals(logins)) {
                    flag = false;
                    System.out.println("Существует логин, введите новый.");
                    break;
                }
            }
        } while (!flag);
        System.out.println("Введите пароль:");
        while (true) {
            password = getString();
            if (password.length() > passwordLength) {
                break;
            }
            System.out.println("Длина пароля должна больше " + passwordLength + " символов");
        }
        pp = new Password(logins, password);
        pp.setId(getNextId());
        pp.setRegistration(true);
        passwordFile.create(pp);
        System.out.println("Логин и пароль записан.");
        return pp;
    }

    public Password entrance() {
        System.out.println("Введите логинн:");
        logins = getString();
        for (Password password1 : passwords) {
            if (password1.getLogin().equals(logins)) {
                System.out.println("Логин верно ввели.\nВведите пароль:");
                password = getString();
                if (password1.getPassword().equals(password)) {
                    System.out.println("Пароль ввели верно.");
                    pp = password1;
                    pp.setRegistration(true);
                    break;
                } else {
                    pp = new Password("0", "0");
                    pp.setRegistration(false);
                    System.out.println("Пароль введён неверно.");
                    break;
                }
            } else {
                pp = new Password("0", "0");
                pp.setRegistration(false);
                System.out.println("Пароль введён неверно.");
                break;
            }
        }
        return pp;
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
