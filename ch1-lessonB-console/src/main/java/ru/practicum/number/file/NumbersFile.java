package ru.practicum.number.file;

import ru.practicum.number.model.Numbers;
import ru.practicum.number.repository.NumbersRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class NumbersFile extends NumbersRepository {
    private final String file;

    public NumbersFile(String file) {
        this.file = file;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            for (Numbers number : findAll().values()) {
                writer.write(String.join("/",
                        String.valueOf(number.getId()),
                        String.valueOf(number.getNum())));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public Map<Long, Numbers> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(long id) {
        save();
        super.deleteById(id);
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
