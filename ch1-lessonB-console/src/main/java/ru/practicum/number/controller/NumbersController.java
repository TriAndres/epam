package ru.practicum.number.controller;

import ru.practicum.number.file.NumbersFile;
import ru.practicum.number.service.NumbersLessonService;
import ru.practicum.number.service.NumbersService;

public class NumbersController {
    private static String file = "ch1-lessonB-console\\src\\main\\java\\ru\\practicum\\number\\file\\NumbersFile.txt";
    private static NumbersFile numbersFile = NumbersFile.loadFromFile(file);

    public static NumbersService numbersService() {
        return new NumbersService(numbersFile);
    }

    public static NumbersLessonService numbersLessonService() {
        return new NumbersLessonService(numbersFile);
    }
}