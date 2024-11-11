package ru.practicum.lessonA.model.numbers.service;

import ru.practicum.lessonA.model.numbers.file.NumbersFile;
import ru.practicum.lessonA.model.numbers.model.Numbers;

import java.util.Random;

import static ru.practicum.lessonA.methods.console.Console.getInteger;
import static ru.practicum.lessonA.methods.console.Console.getString;


public class NumbersLessonService {
    private final NumbersFile file;

    public NumbersLessonService(NumbersFile file) {
        this.file = file;
    }
/*
3. Вывести заданное количество случайных чисел с переходом и без перехода
на новую строку.
*/
    public void lesson3() {
        file.clear();
        setListNumber();
        System.out.println("Вывод количество случайных чисел без переходом на новую строку.");
        show(0);
        System.out.println("Введите количество цифр в строке:");
        int lines = getInteger();
        System.out.println("Вывод количество случайных чисел с переходом на новую строку, через " + lines + " чисел.");
        show(lines);
    }
/*
5. Ввести целые числа как аргументы командной строки, подсчитать их сум-
мы и произведения. Вывести результат на консоль.
 */
    public void lesson5() {
        file.clear();
        int number = 0;
        int sum = 0;
        int mull = 1;
        while (number != -1) {
            System.out.println("Введите цифру:");
            number = getInteger();
            file.numberCreate(new Numbers(getNextId(), number));
            sum += number;
            mull *= number;
            System.out.println("sum = " + sum);
            System.out.println("mull = " + mull);
        }
        System.out.println("выход из цикла.");
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