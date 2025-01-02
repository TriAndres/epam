package ru.practicum.password.service;

import ru.practicum.password.file.PasswordFile;
import ru.practicum.password.model.Password;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ru.practicum.console.Console.getInteger;
import static ru.practicum.console.Console.getString;
import static ru.practicum.password.controller.PasswordController.passwordService;

public class PasswordEmployee {
    private final PasswordFile passwordFile;
    private static Password ps;

    public PasswordEmployee(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
        ps = inProgram();
    }

    public void getTask() {
        if (String.valueOf(ps.getName()).equals("null")) {
            System.out.println("Введите Ваше имя:");
            ps.setName(getString());
            passwordFile.save(ps);
        }

        if (String.valueOf(ps.getLocalDateTime()).equals("null")) {
            LocalDateTime localDateTime = LocalDateTime.now();
            ps.setLocalDateTime(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            passwordFile.save(ps);
        }


        if (ps.getInterval() == 0) {
            System.out.println("Через сколько дней рещите задачи:");
            ps.setInterval(getInteger(-1));
            passwordFile.save(ps);
        }
        reminderTask();
    }

    public  void reminderTask() {
        System.out.println("\n" + ps.getName() + " в " + ps.getLocalDateTime() + ", вы получили задание");
        LocalDateTime time = LocalDateTime.parse(ps.getLocalDateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime time1 = time.plusDays(ps.getInterval());
        String tt = time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd 10:00"));
        System.out.println(ps.getName() + " в " + tt + ", вам сдать решение.");
    }

    public Password inProgram() {
        Password ps = new Password();
        for (Password password : passwordService().findAll()) {
            if (password.getRegistration().equals(true)) {
                ps = password;
            }
        }
        return ps;
    }
}
