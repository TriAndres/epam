package ru.practicum.menu;

import ru.practicum.numbers.menu.NumbersLessonMenu;
import ru.practicum.numbers.menu.NumbersMenuImpl;

import static ru.practicum.console.Console.getInteger;

public class MenuMain {

    public void game() {
        System.out.println("Меню цифр:");
        while (true) {
            int num = menu();
            if (num == 0) break;
            select(num);
        }
        System.out.println("Выход из меню цифр.");
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
}
