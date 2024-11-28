package ru.practicum.number.repository;

import ru.practicum.number.model.Numbers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NumbersRepository {
    private final Map<Long, Numbers> numbersMap = new HashMap<>();

    public Collection<Numbers> findAll() {
        return numbersMap.values();
    }

    public Numbers save(Numbers numbers) {
        numbersMap.put(numbers.getId(), numbers);
        return numbers;
    }

    public Numbers findById(long id) {
        return numbersMap.get(id);
    }

    public boolean containsKey(long id) {
       return numbersMap.containsKey(id);
    }

    public void deleteById(long id) {
        numbersMap.remove(id);
    }

    public void deleteAll() {
        numbersMap.clear();
    }
}
