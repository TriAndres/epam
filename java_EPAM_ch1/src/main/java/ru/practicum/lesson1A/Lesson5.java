package ru.practicum.lesson1A;

import ru.practicum.console.Console;

/*
5. Ввести целые числа как аргументы командной строки, подсчитать их
суммы и произведения. Вывести результат на консоль.
 */
public class Lesson5 implements LessonA {
    @Override
    public void game() {
        int num = 0;
        int sum = 0;
        int mul = 1;
        while (true) {
            System.out.println("Введите целое число или 0 для выхода:");
            num = Console.getInteger();
            if (num == 0) break;
            sum += num;
            mul *= num;
            System.out.println("sum = " + sum);
            System.out.println("mul = " + mul);
        }
        System.out.println("Выход из цикла");
    }
}
