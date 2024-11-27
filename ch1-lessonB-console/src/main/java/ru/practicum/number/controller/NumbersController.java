package ru.practicum.number.controller;

import ru.practicum.number.file.NumbersFile;
import ru.practicum.number.service.NumbersService;

public class NumbersController {
    private static String file = "ch1-lessonB-console\\src\\main\\java\\ru\\practicum\\number\\file\\Numbers.txt";
    private static NumbersFile numbersFile = new NumbersFile(file);

    public static NumbersService numbersService() {
        return new NumbersService(numbersFile);
    }


}