package ru.practicum.menu;

import ru.practicum.console.Console;
import ru.practicum.factory.Factory;

public class MenuA implements Menu{
    private final Factory factory;

    public MenuA(Factory factory) {
        this.factory = factory;
    }
    @Override
    public void game() {
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
                    \t1 - упражнение_1
                    \t2 - упражнение_2
                    \t3 - упражнение_3
                    \t4 - упражнение_4
                    \t5 - упражнение_5
                    \t6 - упражнение_6
                    \t0 - выход из меню
                    """);
    }
    @Override
    public void select(int num) {
        switch (num) {
            case 1:
                factory.task1();
                break;
            case 2:
                factory.task2();
                break;
            case 3:
                factory.task3();
                break;
            case 4:
                factory.task4();
                break;
            case 5:
                factory.task5();
                break;
            case 6:
                factory.task6();
                break;
            default:
                System.out.println("Введите верное действие");
                break;
        }
    }
}