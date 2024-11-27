package ru.practicum.number.repository;

import ru.practicum.number.model.Numbers;

import java.util.HashMap;
import java.util.Map;

public class NumbersRepository {
    private final Map<Long, Numbers> numbersMap = new HashMap<>();

    public Numbers save(Numbers numbers) {
        numbersMap.put(numbers.getId(), numbers);
        return numbers;
    }

    public Numbers findById(long id) {
        return numbersMap.get(id);
    }

    public Map<Long, Numbers> findAll() {
        return numbersMap;
    }

    public void deleteById(long id) {
        numbersMap.remove(id);
    }
}
