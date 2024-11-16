package ru.practicum.lessonA.menu;

import static ru.practicum.lessonA.console.Console.getString;
import static ru.practicum.lessonA.model.argument.controller.ArgumentController.argument;
import static ru.practicum.lessonA.model.numbers.controller.NumbersController.numbersLesson;

public class LessonMenu {

    public void game() {
        while (true) {
            String line = menu();
            if (line.equals("0")) break;
            select(line);
        }
    }

    private String menu() {
        System.out.println("\n\tВыберите действие:" +
                "\n\t1 - Приветствовать любого пользователя при вводе его имени через команд-" +
                "\n\t    ную строку." +
                "\n\t2 - Отобразить в окне консоли аргументы командной строки в обратном по" +
                "\n\t    рядке." +
                "\n\t3 - Вывести заданное количество случайных чисел с переходом и без перехода" +
                "\n\t     на новую строку." +
                "\n\t4 - Ввести пароль из командной строки и сравнить его со строкой-образцом." +
                "\n\t5 - Ввести целые числа как аргументы командной строки, подсчитать их сум-" +
                "\n\t    мы и произведения. Вывести результат на консоль." +
                "\n\t6 - Вывести фамилию разработчика, дату и время получения задания, а также" +
                "\n\t    дату и время сдачи задания." +
                "\n\t0 - для выхода");
        return getString();
    }

    private void select(String line) {
        switch (line) {
            case "1":
                argument().hello();
                break;
            case "2":
                argument().reverse();
                break;
            case "3":
                numbersLesson().lesson3();
                break;
            case "4":
                System.out.println("в разработке");
                ;
                break;
            case "5":
                numbersLesson().lesson5();
                break;
            case "6":
                System.out.println("в разработке");
                break;
            default:
                System.out.println("Выберите предложеные действия");
                break;
        }
    }
}
