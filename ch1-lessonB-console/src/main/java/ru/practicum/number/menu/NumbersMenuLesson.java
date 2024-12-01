package ru.practicum.number.menu;

import static ru.practicum.console.Console.getInteger;
import static ru.practicum.number.controller.NumbersController.numbersLessonService;

public class NumbersMenuLesson implements NumbersMenu{
    @Override
    public void game() {
        System.out.println("Меню решений зададач.");
        while (true) {
            int line = menu();
            if (line == 0) break;
            select(line);
        }
        System.out.println("Выход из меню решений зададач.");
    }

    @Override
    public Integer menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\t1. Четные и нечетные числа." +
                "\n\t2. Наибольшее и наименьшее число." +
                "\n\t3. Числа, которые делятся на 3 или на 9." +
                "\n\t4. Числа, которые делятся на 5 и на 7." +
                "\n\t5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр." +
                "\n\t6. Простые числа." +
                "\n\t7. Отсортированные числа в порядке возрастания и убывания." +
                "\n\t8. Числа в порядке убывания частоты встречаемости чисел." +
                "\n\t9. «Счастливые» числа." +
                "\n\t10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают." +
                "\n\t11. Элементы, которые равны полусумме соседних элементов." +
                "\n\t0 - выйти из меню.");
        return getInteger(-1);
    }

    @Override
    public void select(int line) {
        switch (line) {
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
                System.out.println("В разработке.");
                //numbersLessonService().lesson6();
                break;
            case 7:
                System.out.println("В разработке.");
                //numbersLessonService().lesson7();
                break;
            case 8:
                System.out.println("В разработке.");
                //numbersLessonService().lesson8();
                break;
            case 9:
                System.out.println("В разработке.");
                //numbersLessonService().lesson9();
                break;
            case 10:
                System.out.println("В разработке.");
                //numbersLessonService().lesson10();
                break;
            case 11:
                System.out.println("В разработке.");
                //numbersLessonService().lesson11();
                break;
            default:
                System.out.println("выбирите верное действие.");
                break;
        }
    }
}
