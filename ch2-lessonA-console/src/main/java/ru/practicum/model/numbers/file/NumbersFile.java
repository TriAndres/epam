package ru.practicum.model.numbers.file;

import ru.practicum.model.numbers.model.Numbers;
import ru.practicum.model.numbers.repository.NumbersRepositoryImpl;

import java.io.*;
import java.util.List;

public class NumbersFile extends NumbersRepositoryImpl {
    private final String file;

    public NumbersFile(String file) {
        this.file = file;
    }

    public void saveF() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Numbers numbers : findAll()) {
                writer.write(
                        numbers.toString()
                );
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Numbers> findAll() {
        return super.findAll();
    }

    @Override
    public Numbers save(Numbers numbers) {
        Numbers num = super.save(numbers);
        saveF();
        return num;
    }

    @Override
    public boolean containsKey(long id) {
        saveF();
        return super.containsKey(id);
    }

    @Override
    public Numbers findById(long id) {
        Numbers num = super.findById(id);
        saveF();
        return num;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        saveF();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        saveF();
    }

    public static NumbersFile loadFromFile(String file) {
        NumbersFile numbersFile = new NumbersFile(file);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line=reader.readLine()) != null) {
                String[] row = line.split("/");
                numbersFile.save(new Numbers(
                        Long.parseLong(row[0]),
                        Integer.parseInt(row[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return numbersFile;
    }
}