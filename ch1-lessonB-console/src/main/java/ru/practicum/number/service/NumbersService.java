package ru.practicum.number.service;

import ru.practicum.number.file.NumbersFile;
import ru.practicum.number.model.Numbers;

import static ru.practicum.console.Console.getInteger;

public class NumbersService {
    private final NumbersFile numbersFile;

    public NumbersService(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }
    public void shouNumbers() {

    }

    public void createNum() {
        System.out.println("Введите цифру:");
        numbersFile.save(new Numbers(getInteger(0)));
        System.out.println("Записано.");
    }

    public void findByIdNumber() {

    }

    public void deleteByIdNumber() {

    }

    public void deleteAllNumber() {

    }

    public void createListRandomNumber() {

    }
}
