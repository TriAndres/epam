package ru.practicum.lesson1A;

import ru.practicum.console.Console;

/*
1. Приветствовать любого пользователя при вводе его имени через командную строку.
 */
public class Lesson1 implements LessonA {
    public void game() {
        System.out.println("Введите ваше имя");
        String name = Console.getString();
        System.out.println(name + ", приветствую Вас!");
    }
}