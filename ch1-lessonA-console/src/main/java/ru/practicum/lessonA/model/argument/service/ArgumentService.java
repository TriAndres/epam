package ru.practicum.lessonA.model.argument.service;

import ru.practicum.lessonA.model.argument.file.ArgumentFile;
import ru.practicum.lessonA.model.argument.model.Argument;

import java.util.Scanner;

import static ru.practicum.lessonA.console.Console.getString;
import static ru.practicum.lessonA.model.argument.file.ArgumentFile.loadFromFile;

public class ArgumentService {
    private final ArgumentFile argumentFile;

    public ArgumentService(ArgumentFile argumentFile) {
        this.argumentFile = argumentFile;
    }

    public void lesson1() {
        System.out.println("Введите ваше имя.");
        Argument name = new Argument(getNextId(), getString());
        argumentFile.create(name);
        System.out.println(name.getArgument() + ", Приветствую вас!");
    }

    public void lesson2() {
        System.out.println("Введите аргумент.");
        Argument name = new Argument(getNextId(), getString());
        argumentFile.create(name);
        System.out.println(new StringBuffer().append(name.getArgument()).reverse());
    }


    private Long getNextId() {
        long currentMaxId = argumentFile.getArgumentAll()
                .stream()
                .mapToLong(Argument::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
