package ru.practicum.menu;

import ru.practicum.console.Console;
import ru.practicum.factory.Factory;

public class MenuB implements Menu{
    private final Factory factory;

    public MenuB(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void game() {
        factory.getFile();
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
                    \t7 - упражнение_7
                    \t8 - упражнение_8
                    \t9 - упражнение_9
                    \t10 - упражнение_10
                    \t11 - упражнение_11
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
            case 7:
                factory.task7();
                break;
            case 8:
                factory.task8();
                break;
            case 9:
                factory.task9();
                break;
            case 10:
                factory.task10();
                break;
            case 11:
                factory.task11();
                break;
            default:
                System.out.println("Введите верное действие");
                break;
        }
    }
}
