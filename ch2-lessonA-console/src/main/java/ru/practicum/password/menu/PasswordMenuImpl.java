package ru.practicum.password.menu;

import static ru.practicum.console.Console.getInteger;

public class PasswordMenuImpl implements PasswordMenu{
    @Override
    public void game() {
        System.out.println("Меню паспорта:");
        while (true) {
            int num = menu();
            if (num == 0) break;
            select(num);
        }
        System.out.println("Выход из меню паспорта.");
    }

    @Override
    public int menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - " +
                "\n\t2 - " +
                "\n\t3 - " +
                "\n\t4 - " +
                "\n\t5 - " +
                "\n\t0 - ");
        return getInteger(-1);
    }

    @Override
    public void select(int num) {
        switch (num) {
            case 1:
                System.out.println("в разработке");
                break;
            case 2:
                System.out.println("в разработке");
                break;
            case 3:
                System.out.println("в разработке");
                break;
            case 4:
                System.out.println("в разработке");
                break;
            case 5:
                System.out.println("в разработке");
                break;
            default:
                System.out.println("Выбирите действие из писка.");
                break;
        }
    }
}