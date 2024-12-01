package ru.practicum.number.file;

import ru.practicum.number.model.Numbers;
import ru.practicum.number.repository.NumbersRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class NumbersFile extends NumbersRepository {
    private final String file;

    public NumbersFile(String file) {
        this.file = file;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            for (Numbers number : findAll()) {
                writer.write(
                        String.valueOf(number.getId()) +
                                "/" +
                        String.valueOf(number.getNum()) +
                        "\n"
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Numbers> findAll() {
        return super.findAll();
    }

    @Override
    public Numbers save(Numbers numbers) {
        Numbers n = super.save(numbers);
        save();
        return n;
    }

    @Override
    public Numbers findById(long id) {
        Numbers n = super.findById(id);
        save();
        return n;
    }

    @Override
    public boolean containsKey(long id) {
        save();
        return super.containsKey(id);
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        save();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        save();
    }


    public static NumbersFile loadFromFile(String file) {
        NumbersFile numbersFile = new NumbersFile(file);
        try(BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                numbersFile.save(new Numbers(
                        Long.valueOf(row[0]),
                        Integer.parseInt(row[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbersFile;
    }
}
