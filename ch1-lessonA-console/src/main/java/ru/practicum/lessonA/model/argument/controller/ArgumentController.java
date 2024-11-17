package ru.practicum.lessonA.model.argument.controller;

import ru.practicum.lessonA.model.argument.file.ArgumentFile;
import ru.practicum.lessonA.model.argument.service.ArgumentService;

import static ru.practicum.lessonA.model.argument.file.ArgumentFile.loadFromFile;

public class ArgumentController {
    private static String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\argument\\file\\ArgumentFile.txt";
    private static ArgumentFile argumentFile = loadFromFile(file);

    public static ArgumentService argument() {
        return new ArgumentService(argumentFile);
    }
}