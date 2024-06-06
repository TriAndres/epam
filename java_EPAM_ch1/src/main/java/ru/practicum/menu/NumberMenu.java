package ru.practicum.menu;

import ru.practicum.console.Console;
import ru.practicum.factory.NumberFactory;

public class NumberMenu implements Menu{
    private final NumberFactory numberFactory;

    public NumberMenu(NumberFactory numberFactory) {
        this.numberFactory = numberFactory;
    }

    @Override
    public void game() {
        numberFactory.getFile();
        while (true) {
            menu();
            int num = Console.getInteger();
            if (num == 0) break;
            select(num);
        }
    }

    @Override
    public void menu() {
        System.out.println("""
                    \nВведите действие:
                    \t1 - добавить
                    \t2 - показать список
                    \t3 - очистить
                    \t0 - выход из меню
                    """);
    }

    @Override
    public void select(int num) {
        switch (num) {
            case 1:
                numberFactory.createRandomNum();
                break;
            case 2:
                numberFactory.show();
                break;
            case 3:
                numberFactory.clear();
                break;
            default:
                System.out.println("Введите верное действие");
                break;
        }
    }
}
