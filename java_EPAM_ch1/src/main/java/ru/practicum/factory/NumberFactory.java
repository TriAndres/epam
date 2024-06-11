package ru.practicum.factory;

import ru.practicum.console.Console;
import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.Random;

public class NumberFactory {
    private final NumberMeneger numberMeneger;

    public NumberFactory(NumberMeneger numberMeneger) {
        this.numberMeneger = numberMeneger;
    }

    public void createNum() {
        System.out.println("Введите цифру:");
        numberMeneger.create(new Number(Console.getInteger()));
        System.out.println("Записано");
    }
    public void createRandomNum() {
        System.out.println("Введите количество цифр:");
        int size = Console.getInteger();
        System.out.println("Введите диапазон от ");
        int from = Console.getInteger();
        System.out.println("Введите диапазон до");
        int to = Console.getInteger();
        for (int i = 0; i < size; i++) {
            numberMeneger.create(new Number(from + new Random().nextInt(to - from)));
        }
    }

    public void show() {
        int count = 0;
        int len = 10;
        if (!numberMeneger.getNumberList().isEmpty()) {
            for (int i = 0; i < numberMeneger.getNumberList().size(); i++) {
                System.out.print(numberMeneger.getById(i).getNum() + " ");
                count++;
                if (count == len) {
                    System.out.println();
                    count = 0;
                }
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    public void clear() {
        numberMeneger.clear();
    }

    public void getFile() {
        numberMeneger.getFile();
    }
}
