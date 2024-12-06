package ru.practicum.numbers.menu;

import static ru.practicum.console.Console.getInteger;
import static ru.practicum.numbers.controller.NumbersController.numbersLessonService;

public class NumbersLessonMenu implements NumbersMenu {
    @Override
    public void game() {
        System.out.println("Меню задач:");
        while (true) {
            int num = menu();
            if (num == 0) break;
            select(num);
        }
        System.out.println("Выход из меню цифр.");
    }

    @Override
    public int menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - задача." +
                "\n\t2 - задача." +
                "\n\t3 - задача." +
                "\n\t4 - задача." +
                "\n\t5 - задача." +
                "\n\t6 - задача." +
                "\n\t7 - задача." +
                "\n\t8 - задача." +
                "\n\t9 - задача." +
                "\n\t0 - выйти из меню задач.");
        return getInteger(-1);
    }

    @Override
    public void select(int num) {
        switch (num) {
            case 1:
                numbersLessonService().lesson1();
                break;
            case 2:
                numbersLessonService().lesson2();
                break;
            case 3:
                numbersLessonService().lesson3();
                break;
            case 4:
                numbersLessonService().lesson4();
                break;
            case 5:
                numbersLessonService().lesson5();
                break;
            case 6:
                numbersLessonService().lesson6();
                break;
            case 7:
                numbersLessonService().lesson7();
                break;
            case 8:
                numbersLessonService().lesson8();
                break;
            case 9:
                numbersLessonService().lesson9();
                break;
            default:
                System.out.println("Выбирите действие из писка.");
                break;
        }
    }
}
