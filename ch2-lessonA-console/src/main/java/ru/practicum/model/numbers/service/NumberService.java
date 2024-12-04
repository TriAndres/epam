package ru.practicum.model.numbers.service;

import ru.practicum.model.numbers.file.NumbersFile;
import ru.practicum.model.numbers.model.Numbers;

public class NumberService {
    private final NumbersFile numbersFile;

    public NumberService(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    private Long getNextId() {
        long currentMaxId = numbersFile.findAll().stream()
                .mapToLong(Numbers::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}