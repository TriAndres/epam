package ru.practicum.model.numbers.file;

import ru.practicum.model.numbers.model.Numbers;
import ru.practicum.model.numbers.repository.NumbersRepositoryImpl;

import java.util.List;

public class NumbersFile extends NumbersRepositoryImpl {
    private final String file;

    public NumbersFile(String file) {
        this.file = file;
    }

    public void saveF() {

    }

    @Override
    public List<Numbers> findAll() {
        return super.findAll();
    }

    @Override
    public void save(Numbers numbers) {
        super.save(numbers);
    }

    @Override
    public Numbers findById(long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    public static NumbersFile loadFromFile(String file) {
        NumbersFile numbersFile = new NumbersFile(file);

        return numbersFile;
    }
}