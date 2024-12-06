package ru.practicum.numbers.controller;

import ru.practicum.numbers.file.NumbersFile;
import ru.practicum.numbers.service.NumberService;
import ru.practicum.numbers.service.NumbersLessonService;

import static ru.practicum.numbers.file.NumbersFile.loadFromFile;

public class NumbersController {
    private static final String file = "ch2-lessonA-console\\src\\main\\java\\ru\\practicum\\numbers\\file\\NumbersFile.txt";
    public static final NumbersFile numbersFile = loadFromFile(file);

    public static NumberService numberService() {
        return new NumberService(numbersFile);
    }

    public static NumbersLessonService numbersLessonService() {
        return new NumbersLessonService(numbersFile);
    }
}
