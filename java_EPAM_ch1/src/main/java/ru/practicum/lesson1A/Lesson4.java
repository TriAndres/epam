package ru.practicum.lesson1A;

import ru.practicum.console.Console;

/*
4. Ввести пароль из командной строки и сравнить его со строкой-образцом.
 */
public class Lesson4 implements LessonA {
    @Override
    public void game() {
        String password = "password";
        String line = null;
        while (true) {
            line = Console.getString();
            if (line.equals("0")) {
                System.out.println("Ввели 0, выход из цикла");
                break;
            }
            if (line.equals(password)) {
                System.out.println("Ввели верно, выход из цикла");
            }
            System.out.println("Введите пароль или 0 для выхода:");
        }
    }
}