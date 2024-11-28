package ru.practicum.number.service;

import ru.practicum.number.file.NumbersFile;
import ru.practicum.number.model.Numbers;

import java.util.Random;

import static ru.practicum.console.Console.getInteger;

public class NumbersService {
    private final NumbersFile numbersFile;
    private Numbers nn;

    public NumbersService(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    public void createNum() {
        System.out.println("Введите цифру:");
        nn = new Numbers(getNextId(),getInteger(0));
        numbersFile.save(nn);
        System.out.println("Записано.");
    }

    public void shouNumbers() {
        if (!numbersFile.findAll().isEmpty()) {
            System.out.println("Введите количество цифр в строке:");
            int line = getInteger(0);
            int count = 0;
            System.out.println("id/numbers");
            for (Numbers numbers : numbersFile.findAll()) {
                System.out.print("\t" + numbers.getId() + "/" + numbers.getNum());
                count++;
                if (count >= line) {
                    System.out.println();
                    count = 0;
                }
            }
        } else {
            System.out.println("Заполните список для отображения.");
        }
    }


    public void deleteByIdNumber() {
        System.out.println("Удалить цифру по id:");
        int num = getInteger(0);
        if (numbersFile.containsKey(Long.parseLong(String.valueOf(num)))) {
            numbersFile.deleteById(num);
            System.out.println("Удалили.");
        } else {
            System.out.println("В списке id отсутствует.");
        }
    }

    public void deleteAllNumber() {
        numbersFile.deleteAll();
        System.out.println("Список пуст");
    }

    public void createListRandomNumber() {
        System.out.println("Введите количество цифр:");
        int count = getInteger(0);
        System.out.println("Введите диапвзон цифр\nfrom:");
        int from = getInteger(0);
        System.out.println("to:");
        int to = getInteger(from);
        for (int i = 0; i < count; i++) {
            nn = new Numbers(getNextId(),from + new Random().nextInt(to - from));
            numbersFile.save(nn);
        }
        System.out.println("Список цифр записан.");
    }

    public Long getNextId() {
        long currentMaxId = numbersFile.findAll()
                .stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}