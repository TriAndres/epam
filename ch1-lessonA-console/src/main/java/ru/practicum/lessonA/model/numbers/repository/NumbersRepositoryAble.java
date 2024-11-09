package ru.practicum.lessonA.model.numbers.repository;

import ru.practicum.lessonA.model.numbers.model.Numbers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NumbersRepositoryAble implements NumbersRepository{
    private final Map<Long, Numbers> numbersMap = new HashMap<>();

    public Collection<Numbers> numberGetAll() {
        return numbersMap.values();
    }

    public Numbers numberCreate(Numbers number) {
        return numbersMap.put(number.getId(), number);
    }

    public boolean containsKey(long id) {
        return numbersMap.containsKey(id);
    }

    public Numbers findById(long id) {
        return numbersMap.get(id);
    }

    public void deleteId(long id) {
        numbersMap.remove(id);
    }

    public void clear() {
        numbersMap.clear();
    }
}