package ru.practicum.lessonA.model.numbers.service;

import ru.practicum.lessonA.model.numbers.model.Numbers;
import ru.practicum.lessonA.model.numbers.repository.NumbersFile;

import java.util.Random;
import java.util.Scanner;

import static ru.practicum.lessonA.model.numbers.repository.NumbersFile.loadFromFile;
import static ru.practicum.lessonA.model.numbers.service.Console.*;

/*
3. Вывести заданное количество случайных чисел с переходом и без перехода
на новую строку.
 */
public class NumbersService {
    private final String files = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\numbers\\repository\\Numbers.txt";
    private final NumbersFile file = loadFromFile(files);

    public static void main(String[] args) {
        NumbersService s = new NumbersService();
        s.setListNumber();
        s.show();
    }

    public void save() {
        System.out.println("Введите цифру:");
        file.numberCreate(new Numbers(getLong()));
        System.out.println("Записано.");
    }

    public void setListNumber() {
        int size = 0;
        long from = 0L;
        long to = 0L;
        System.out.println("Введите в формате количество/от/до случайных чисел:\n" +
                "пример:100/30/99");
        String[] line = null;
        String text = "";
        while (true) {
            text = getString();
            line = text.split("/");

            if (line.length == 3) {
                break;
            }
            System.out.println("пример ввода:100/30/99");
        }
        if (Integer.parseInt(line[0]) > 0 && Integer.parseInt(line[1]) > 0 && Integer.parseInt(line[2]) > Integer.parseInt(line[1])) {
            size = Integer.parseInt(line[0]);
            from = Long.parseLong(line[1]);
            to = Long.parseLong(line[2]);
            for (int i = 1; i <= size; i++) {
                file.numberCreate(new Numbers(from + new Random().nextLong(to - from)));
            }
            System.out.println("записано");
        }
        System.out.println("пример ввода:100/30/99");

    }

    public void show() {
        System.out.println("Введите количество цифр в строке:");
        int line = getInteger();
        System.out.println("Вывод: id/num.");
        int count = 0;
        for (Numbers number : file.numberGetAll()) {
            System.out.print(number.getId() + "/" + number.getNum() + "  ");
            ++count;
            if (count == line) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println("\nСписок выведен.");
    }
}