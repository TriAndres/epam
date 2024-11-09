package ru.practicum.lessonA.model.numbers.service;

import ru.practicum.lessonA.model.numbers.file.NumbersFile;
import ru.practicum.lessonA.model.numbers.model.Numbers;

import java.util.Random;

import static ru.practicum.lessonA.methods.console.Console.getInteger;
import static ru.practicum.lessonA.methods.console.Console.getString;
import static ru.practicum.lessonA.model.numbers.file.NumbersFile.loadFromFile;

/*
3. Вывести заданное количество случайных чисел с переходом и без перехода
на новую строку.
 */
public class NumbersLesson3Service {
    private final NumbersFile file;

    public NumbersLesson3Service(NumbersFile file) {
        this.file = file;
    }

    public void lesson3() {
        file.clear();
        setListNumber();
        System.out.println("Вывод чисел без перехода на новую строку.");
        show(0);
        System.out.println("Введите количество цифр в строке:");
        int lines = getInteger();
        System.out.println("Вывод количество случайных чисел с переходом на новую строку, через " + lines + " чисел.");
        show(lines);
    }

    private void setListNumber() {
        int size = 0;
        int from = 0;
        int to = 0;
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
            from = Integer.parseInt(line[1]);
            to = Integer.parseInt(line[2]);
            for (int i = 1; i <= size; i++) {
                file.numberCreate(new Numbers(getNextId(), from + new Random().nextInt(to - from)));
            }
            System.out.println("записано");
        }
    }

    private void show(int line) {
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

    private long getNextId() {
        long currentMaxId = file.numberGetAll()
                .stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}