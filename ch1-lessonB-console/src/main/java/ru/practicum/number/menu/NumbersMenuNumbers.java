package ru.practicum.number.menu;

import static ru.practicum.console.Console.getInteger;
import static ru.practicum.number.controller.NumbersController.numbersService;

public class NumbersMenuNumbers implements NumbersMenu{

    @Override
    public void game() {
        System.out.println("Меню цифр.");
        while (true) {
            int line = menu();
            if (line == 0) break;
            select(line);
        }
        System.out.println("Выход из меню цифр.");
    }

    @Override
    public Integer menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - записать цифру." +
                "\n\t2 - обновление цифры по id." +
                "\n\t3 - записать список цифр." +
                "\n\t4 - удалить цифру по id." +
                "\n\t5 - удалить список цифр." +
                "\n\t6 - вывести список" +
                "\n\t0 - выйти из меню.");
        return getInteger(-1);
    }

    @Override
    public void select(int line) {
        switch (line) {
            case 1:
                numbersService().createNum();
                break;
            case 2:
                System.out.println("В разработке.");
                break;
            case 3:
                numbersService().createListRandomNumber();
                break;
            case 4:
                numbersService().deleteByIdNumber();
                break;
            case 5:
                numbersService().deleteAllNumber();
                break;
            case 6:
                numbersService().shouNumbers();
                break;
            default:
                System.out.println("выбирите верное действие.");
                break;
        }
    }
}
