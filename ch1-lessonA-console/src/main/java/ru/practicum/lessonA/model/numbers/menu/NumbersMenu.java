package ru.practicum.lessonA.model.numbers.menu;

import ru.practicum.lessonA.model.numbers.controller.NumbersController;

import static ru.practicum.lessonA.methods.console.Console.getString;

public class NumbersMenu {

    public void game() {
            System.out.println("3. Вывести заданное количество случайных чисел с переходом и без перехода\n" +
                    "на новую строку.");
            while (true) {
                String line = menu();;
                if (line.equals("0")) break;
                select(line);
            }
            System.out.println("Выход из программы.");
    }

    public String menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1 - записать." +
                "\n\t2 - записать список" +
                "\n\t3 - вывод списка." +
                "\n\t0 - выход из программы.");
        return getString();
    }

    public void select(String line) {
//        switch (line) {
//            case "1":
//                NumbersController.game().save();
//                break;
//            case "2":
//                NumbersController.game().setListNumber();
//                break;
//            case "3":
//                NumbersController.game().show();
//                break;
//            default:
//                System.out.println("Введите предлагаемые действия");
//                break;
//        }
    }
}
