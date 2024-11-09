package ru.practicum.lessonA.model.numbers.controller;

import ru.practicum.lessonA.model.numbers.file.NumbersFile;
import ru.practicum.lessonA.model.numbers.service.NumbersLesson3Service;
import ru.practicum.lessonA.model.numbers.service.NumbersLesson5Service;

import static ru.practicum.lessonA.model.numbers.file.NumbersFile.loadFromFile;

public class NumbersController {
    private static String files = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\numbers\\file\\Numbers.txt";
    private static NumbersFile numbersFile = loadFromFile(files);

    public static NumbersLesson3Service numbersLesson3() {
        return new NumbersLesson3Service(numbersFile);
    }

    public static NumbersLesson5Service numbersLesson5() {
        return new NumbersLesson5Service(numbersFile);
    }
}