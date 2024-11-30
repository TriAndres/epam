package ru.practicum.menu;

import ru.practicum.number.menu.NumbersMenuLesson;
import ru.practicum.number.menu.NumbersMenuNumbers;

import static ru.practicum.console.Console.getInteger;

public class MenuMain {

    public void game() {
        System.out.println("Меню главное.");
        while (true) {
            int line = menu();
            if (line == 0) break;
            select(line);
        }
        System.out.println("Выход из программы.");
    }

    public Integer menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - Меню цифр." +
                "\n\t2 - Меню решений зададач." +
                "\n\t0 - выйти из программы.");
        return getInteger(-1);
    }

    public void select(int line) {
        switch (line) {
            case 1:
                new NumbersMenuNumbers().game();
                break;
            case 2:
                new NumbersMenuLesson().game();
                break;
            default:
                System.out.println("выбирите верное действие.");
                break;
        }
    }
}