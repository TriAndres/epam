package ru.practicum.lessonA.model.numbers.service;

import org.w3c.dom.ls.LSOutput;
import ru.practicum.lessonA.model.numbers.file.NumbersFile;
import ru.practicum.lessonA.model.numbers.model.Numbers;

import static ru.practicum.lessonA.methods.console.Console.getInteger;

/*
5. Ввести целые числа как аргументы командной строки, подсчитать их сум-
мы и произведения. Вывести результат на консоль.
 */
public class NumbersLesson5Service {
    private final NumbersFile file;

    public NumbersLesson5Service(NumbersFile file) {
        this.file = file;
    }

    public void lesson5() {
        file.clear();
        int number = 0;
        int sum = 0;
        int mull = 1;
        while(number != -1) {
            System.out.println("Введите цифру:");
           number = getInteger();
           file.numberCreate(new Numbers(getNextId(),number));
           sum += number;
           mull *= number;
            System.out.println("sum = " + sum);
            System.out.println("mull = " + mull);
        }
        System.out.println("выход из цикла.");
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