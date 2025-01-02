package ru.practicum.lesson.lesson;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

public class Lesson1 {
    public static void main(String[] args) {
        //lesson1(2, 10);
        //lesson2(50, 100, 20, 10);
        //lesson4(1,100, 10, i -> i % 3 == 0);
        lesson5(129);
    }

    public static void lesson1(int a, int b) {
        //System.out.println("1 Вывести на экран таблицу умножения.");
        if (a > 0 || b > 0) {
            for (int i = 2; i <= 10; i++) {
                for (int j = a; j <= b; j++) {
                    System.out.printf("\t\t%d * %d = %d", j, i, (j * i));
                }
                System.out.println();
            }
        } else {
            System.out.println("Ошибка: ввод < 0");
        }
    }

    public static void lesson2(int from, int to, int size, int length) {
        if (from < to) {
            //System.out.println("2 Вывести элементы массива в обратном порядке.");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i <= size; i++) {
                list.add(from + new Random().nextInt(to - from));
            }
            int count = 0;
            System.out.println("Ввод:");
            for (Integer i : list) {
                System.out.print("\t" + i);
                count++;
                if (count == length) {
                    System.out.println();
                    count = 0;
                }
            }
            count = 0;
            System.out.println("\nВ обратном порядке:");
            for (int i = list.size(); i > 0 ; i--) {
                System.out.print("\t" + list.get(i - 1));
                count++;
                if (count == length) {
                    System.out.println();
                    count = 0;
                }
            }
        } else {
            System.out.println("Ошибка: from > to");
        }
    }

    public static void lesson3() {
        System.out.println("3 Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].");
    }

    public static void lesson4(int from, int to, int length, Predicate<Integer> predicate) {
        if (from < to) {
            //System.out.println("4 Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.");
            int count = 0;
            for (int i = from; i <= to; i++) {
                if (predicate.test(i)) { //i % 3 == 0
                    System.out.printf("\t%d",i);
                    count++;
                    if (count == length) {
                        System.out.println();
                        count = 0;
                    }
                }
            }
        } else {
            System.out.println("Ошибка: from > to");
        }
    }

    public static void lesson5(int number) {
        //System.out.println("5 Сколько значащих нулей в двоичной записи числа 129?");
        int count = 0;
        StringBuilder line = new StringBuilder();
        while (number >= 1) {
            if (number % 2 == 0) {
                line.append("0");
                count++;
            } else {
                line.append("1");
            }
            number = number / 2;
        }
        System.out.println(line.reverse() + "\n0=" + count); //10000001
    }

    public static void lesson6() {
        System.out.println("6 В системе счисления с некоторым основанием десятичное число 81 запи-\n" +
                "сывается в виде 100. Найти это основание.");
    }

    public static void lesson7() {
        System.out.println("7 Написать код программы, которая бы переводила числа из десятичной сис-\n" +
                "темы счисления в любую другую.");
    }

    public static void lesson8() {
        System.out.println("8 Написать код программы, которая бы переводила числа одной любой сис-\n" +
                " темы счисления в любую другую.");
    }

    public static void lesson9() {
        System.out.println("9 Ввести число от 1 до 12. Вывести на консоль название месяца, соответствую-\n" +
                " щего данному числу. Осуществить проверку корректности ввода чисел.");
    }
}
