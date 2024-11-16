package ru.practicum.lessonA.menu;

import ru.practicum.lessonA.model.password.controller.PasswordController;
import ru.practicum.lessonA.model.password.model.Password;

import static ru.practicum.lessonA.console.Console.getString;


public class Menu {
    private LessonMenu lessonMenu;

    public Menu() {
        lessonMenu = new LessonMenu();
    }

    public void game() {
        while (true) {
            String line = menu();
            if (line.equals("0")) break;
            select(line);
        }
    }

    private String menu() {
        System.out.println("\n\tВыберите действие:" +
                "\n\t1 - регистрация" +
                "\n\t2 - вход" +
                "\n\t0 - выход из программы");
        return getString();
    }

    private void select(String line) {
        switch (line) {
            case "1": {
                Password password = PasswordController.password().registration();
                if (password.getRegistration()) {
                    lessonMenu.game();
                    password.setRegistration(false);
                    System.out.println("Вышли из программы.");
                    break;
                } else {
                    break;
                }

            }
            case "2": {
                Password password = PasswordController.password().entrance();
                if (password.getRegistration()) {
                    lessonMenu.game();
                    password.setRegistration(false);
                    System.out.println("Вышли из программы.");
                    break;
                } else {
                    break;
                }
            }
            default:
                System.out.println("Выберите предложеные действия");
                break;
        }
    }
}