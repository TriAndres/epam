package ru.practicum.lesson1A;

import ru.practicum.console.Console;

/*
2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
 */
public class Lesson2 implements LessonA {
    @Override
    public void game() {
        System.out.println("Введите аргумент");
        String string = Console.getString();
        System.out.println("Ввели:\n" + string);
        StringBuilder st = new StringBuilder(string).reverse();
        System.out.println("В обратном порядке:\n" + st);
    }
}