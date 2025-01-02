package ru.practicum.numbers.service;

import ru.practicum.numbers.file.NumbersFile;
import ru.practicum.numbers.model.Numbers;

import static ru.practicum.console.Console.getInteger;

public class NumberService {
    private final NumbersFile numbersFile;

    public NumberService(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    public void findAll() {
        int count = 0;
        if (!numbersFile.findAll().isEmpty()) {
            System.out.println("Введите длину из цифр:");
            int sizeLine = getInteger(0);
            for (Numbers numbers : numbersFile.findAll()) {
                System.out.print("\t" + numbers.getId() + "/" + numbers.getNumber());
                count++;
                if (count == sizeLine) {
                    System.out.println();
                    count = 0;
                }
            }
            System.out.println("Вывод списка.");
        } else {
            System.out.println("Спмсок отсутсвкет.");
        }
    }

    public void create() {
        System.out.println("Введите цифру:");
        numbersFile.save(new Numbers(getNextId(), getInteger(0)));
        System.out.println("Записали.");
    }

    public void update() {
        System.out.println("Введите id цифры обновления:");
        int id = getInteger(0);
        if (numbersFile.containsKey(id)) {
            Numbers oldNum = numbersFile.findById(id);
            System.out.println("Введите новую цифру");
            oldNum.setNumber(getInteger(0));
            numbersFile.save(oldNum);
            System.out.println("Обновили.");
        } else {
            System.out.println("Введите id из списка.");
        }
    }

    public void deleteById() {
        System.out.println("Введите id цифры для удаления:");
        int id = getInteger(0);
        if (numbersFile.containsKey(id)) {
            numbersFile.deleteById(id);
            System.out.println("Удалено.");
        } else {
            System.out.println("Введите id из списка.");
        }
    }

    public void deleteAll() {
        if (numbersFile.findAll().isEmpty()) {
            numbersFile.deleteAll();
            System.out.println("Удалено.");
        } else {
            System.out.println("Списка не существует.");
        }
    }

    private Long getNextId() {
        long currentMaxId = numbersFile.findAll().stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}