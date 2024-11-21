package ru.practicum.lessonA.menu;

import ru.practicum.lessonA.model.password.controller.PasswordController;
import ru.practicum.lessonA.model.password.model.Password;

import static ru.practicum.lessonA.console.Console.getString;
import static ru.practicum.lessonA.model.password.controller.PasswordController.*;


public class Menu {
    private LessonMenu lessonMenu;

    public Menu() {
        lessonMenu = new LessonMenu();
    }

    public void game() {
        setRegistration();
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
                Password password = password().getById(passwordService().registration());
                if (password.getRegistration()) {
                    lessonMenu.game();
                    password.setRegistration(false);
                    password().create(password);
                    System.out.println("Вышли из программы.");
                    break;
                } else {
                    break;
                }
            }
            case "2": {
                passwordService().entrance();
                long id = 0;
                for (Password password : password().getByAll()) {
                    if (password.getRegistration().equals(true)) {
                        id = password.getId();
                        break;
                    }
                }
                if (id != 0) {
                    Password password = password().getById(Integer.parseInt(String.valueOf(id)));
                    if (password.getRegistration()) {
                        lessonMenu.game();
                        password.setRegistration(false);
                        password().create(password);
                        System.out.println("Вышли из программы.");
                        break;
                    } else {
                        break;
                    }
                }
            }
            default:
                System.out.println("Выберите предложеные действия");
                break;
        }
    }

    private void setRegistration() {
        for (Password password : password().getByAll()) {
            password.setRegistration(false);
            password().create(password);
        }
    }
}