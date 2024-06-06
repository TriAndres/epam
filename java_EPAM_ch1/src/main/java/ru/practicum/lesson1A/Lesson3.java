package ru.practicum.lesson1A;

import ru.practicum.console.Console;

import java.util.Random;

/*
3. Вывести заданное количество случайных чисел с переходом и без перехода
на новую строку.
 */
public class Lesson3 implements LessonA {
    private int[] line;

    @Override
    public void game() {
        System.out.println("\nВведите количество случайных чисел");
        int num = Console.getInteger();
        init(num);
        setNumRandom(5, 100);
        System.out.println("Чисел с переходом:");
        show(10);
        System.out.println("\nЧисел без перехода:");
        show(0);
    }

    private void init(int num) {
        line = new int[num];
    }

    private void setNumRandom(int from, int to) {
        for (int i = 0; i < line.length; i++) {
            line[i] = from + new Random().nextInt(to - from);
        }
    }

    private void show(int len) {
        int count = 0;
        for (int j : line) {
            System.out.print(j + " ");
            count++;
            if (count == len) {
                System.out.println();
                count = 0;
            }
        }
    }
}
