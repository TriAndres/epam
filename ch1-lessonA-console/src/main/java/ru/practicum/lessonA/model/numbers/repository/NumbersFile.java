package ru.practicum.lessonA.model.numbers.repository;

import ru.practicum.lessonA.model.numbers.model.Numbers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class NumbersFile extends NumbersRepository {
    private final String file;

    private NumbersFile(String file) {
        this.file = file;
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            for (Numbers number : numberGetAll()) {
                writer.write(String.valueOf(number.getId()) + "/" + String.valueOf(number.getNum()) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Numbers> numberGetAll() {
        return super.numberGetAll();
    }

    @Override
    public void numberCreate(Numbers number) {
        super.numberCreate(number);
        save();
    }

    public static NumbersFile loadFromFile(String files) {
        NumbersFile service = new NumbersFile(files);
        try (BufferedReader reader = new BufferedReader(new FileReader(files, StandardCharsets.UTF_8))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                service.numberCreate(new Numbers(Long.valueOf(row[0]), Long.valueOf(row[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return service;
    }
}