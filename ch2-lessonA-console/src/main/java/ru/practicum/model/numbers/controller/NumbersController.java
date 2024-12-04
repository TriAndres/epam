package ru.practicum.model.numbers.controller;

import ru.practicum.model.numbers.file.NumbersFile;
import ru.practicum.model.numbers.service.NumberService;

import static ru.practicum.model.numbers.file.NumbersFile.loadFromFile;

public class NumbersController {
    private static final String file = "ch2-lessonA-console\\src\\main\\java\\ru\\practicum\\model\\numbers\\file\\NumbersFile.txt";
    public static final NumbersFile numbersFile = loadFromFile(file);

    public static NumberService numberService() {
        return new NumberService(numbersFile);
    }
}
