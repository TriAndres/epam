package ru.practicum.password.menu;

import ru.practicum.password.model.Password;

import static ru.practicum.console.Console.getInteger;
import static ru.practicum.password.controller.PasswordController.passwordService;

public class PasswordMenuImpl implements PasswordMenu{
    @Override
    public void game() {
        System.out.println("Меню паспорта:");
        while (true) {
            int num = menu();
            if (num == 0) break;
            select(num);
            if (flag()) {
                break;
            }
        }
        System.out.println("Выход из меню паспорта.");
    }

    @Override
    public int menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - регистрация." +
                "\n\t2 - вход" +
                "\n\t0 - выход из программы.");
        return getInteger(-1);
    }

    @Override
    public void select(int num) {
        switch (num) {
            case 1:
                passwordService().registration();
                break;
            case 2:
                passwordService().entrance();
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