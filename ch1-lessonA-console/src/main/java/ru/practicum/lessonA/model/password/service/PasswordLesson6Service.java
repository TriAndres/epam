package ru.practicum.lessonA.model.password.service;

import ru.practicum.lessonA.model.password.file.PasswordFile;
import ru.practicum.lessonA.model.password.model.Password;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ru.practicum.lessonA.console.Console.getString;
import static ru.practicum.lessonA.model.password.file.PasswordFile.loadFromFile;

public class PasswordLesson6Service {
    private final PasswordFile passwordFile;

    public PasswordLesson6Service(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public static void main(String[] args) {
        String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
        PasswordFile passwordFile = loadFromFile(file);
        PasswordLesson6Service pls = new PasswordLesson6Service(passwordFile);

        pls.lesson6();
    }

    /*
     6. Вывести фамилию разработчика, дату и время получения задания, а также
    дату и время сдачи задания.
     */
    public void lesson6() {
        long id = 0;
        for (Password password : passwordFile.getByAll()) {
            if (password.getRegistration().equals(true)) {
                id = password.getId();
            }
        }
        Password password = passwordFile.getById(id);
        if (password.getName().equals("null")) {
            System.out.println("Введите имя:");
            password.setName(getString());
            passwordFile.create(password);
        }
        if (password.getLocalDateTime().equals("null")) {
            password.setLocalDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            passwordFile.create(password);
        }
        System.out.println(password.getName() + " в " + password.getLocalDateTime() + ", вы получили задание");
    }
}