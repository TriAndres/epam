package ru.practicum.menu;

import ru.practicum.numbers.menu.NumbersLessonMenu;
import ru.practicum.numbers.menu.NumbersMenuImpl;
import ru.practicum.password.model.Password;

import java.util.ArrayList;
import java.util.List;

import static ru.practicum.console.Console.getInteger;
import static ru.practicum.console.Console.getString;
import static ru.practicum.password.controller.PasswordController.passwordService;

public class MenuMain {

    public void game() {
        boolean input = false;
        while (true){
            if (!passwordService().findAll().isEmpty()) {
                for (Password password : passwordService().findAll()) {
                    password.setRegistration(false);
                }
            }

            System.out.println("\n\tВыбирите действие:" +
                    "\n\t1 - регистрацмя" +
                    "\n\t2 - вход в программу" +
                    "\n\t0 - выход из программы");
            int line = getInteger(-1);
            if (line == 0) {
                break;
            } else if (line == 1) {
                passwordService().registration();
            } else if (line == 2) {
                passwordService().entrance();
            }
            if (flag()) {
                input = true;
                break;
            }
        }
        ///////////////////////////////////////////////
        /*
        String name = "";
        for (Password password : passwordService().findAll()) {
            if (password.getRegistration().equals(true)) {
                name = password.getName();
            }
        }
        if (name == null) {
            System.out.println("Введите Ваше имя:");
            name = getString();

        }
        */
        ///////////////////////////////////////////////
        if(input) {
            System.out.println("Меню цифр:");
            while (true) {
                int num = menu();
                if (num == 0) break;
                select(num);
            }
            System.out.println("Выход из меню цифр.");
        }
    }

    private int menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - Меню цифр." +
                "\n\t2 - Меню задач." +
                "\n\t0 - выйти из программы.");
        return getInteger(-1);
    }

    private void select(int num) {
        switch (num) {
            case 1:
                new NumbersMenuImpl().game();
                break;
            case 2:
                new NumbersLessonMenu().game();
                break;
            default:
                System.out.println("Выбирите действие из писка.");
                break;
        }
    }

    private boolean flag() {
        for (Password password : passwordService().findAll()) {
            if (password.getRegistration().equals(true)) {
                return true;
            }
        }
        return false;
    }

}