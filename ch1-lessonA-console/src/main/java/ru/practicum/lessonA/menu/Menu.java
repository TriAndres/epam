package ru.practicum.lessonA.menu;

import ru.practicum.lessonA.model.lesson1.UserController;
import ru.practicum.lessonA.model.lesson2.ArgumentController;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void game() {
        while (true) {
            String line = menu();
            if (line.equals("0")) break;
            select(line);
        }
        System.out.println("Вышли из программы.");
    }

    private String menu() {
        System.out.println("\n\tВыберите действие:" +
                "\n\t1 - задача" +
                "\n\t2 - задача" +
                "\n\t0 - для выхода");
        return scanner.next();
    }

    private void select(String line) {
        switch (line) {
            case "1":
                new UserController().user().game();
                break;
            case "2":
                new ArgumentController().argument().game();
                break;
            default:
                System.out.println("Выберите предложеное действие");
                break;

        }
    }
}