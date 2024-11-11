package ru.practicum.lessonA.model.numbers.controller;

import ru.practicum.lessonA.model.numbers.file.NumbersFile;
import ru.practicum.lessonA.model.numbers.service.NumbersLessonService;

import static ru.practicum.lessonA.model.numbers.file.NumbersFile.loadFromFile;

public class NumbersController {
    private static String files = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\numbers\\file\\Numbers.txt";
    private static NumbersFile numbersFile = loadFromFile(files);

    public static NumbersLessonService numbersLesson() {
        return new NumbersLessonService(numbersFile);
    }

}