package ru.practicum.model.numbers.menu;

import static ru.practicum.console.Console.getInteger;
import static ru.practicum.model.numbers.controller.NumbersController.numberService;

public class NumbersMenuImpl implements NumbersMenu{

    @Override
    public void game() {
        System.out.println("Меню цифр:");
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
                "\n\t1 - вывести весь список." +
                "\n\t2 - записать цифру." +
                "\n\t3 - обновить цифру." +
                "\n\t4 - удалить цифру по id." +
                "\n\t5 - удалить весь список." +
                "\n\t0 - выйти из меню цифр.");
        return getInteger(-1);
    }

    @Override
    public void select(int num) {
        switch (num) {
            case 1:
                numberService().findAll();
                break;
            case 2:
                numberService().create();
                break;
            case 3:
                numberService().update();
                break;
            case 4:
                numberService().deleteById();
                break;
            case 5:
                numberService().deleteAll();
                break;
            default:
                System.out.println("Выбирите действие из писка.");
                break;
        }
    }
}