package ru.practiicum.model.manager;

import ru.practiicum.model.number.Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberManager implements NumberManagerAble{
    private final Map<Integer, Numbers> map = new HashMap<>();
    private static Integer id;

    public static Integer getId() {
        return ++id;
    }

    @Override
    public List<Numbers> getNumbers() {
        return new ArrayList<>(map.values());
    }
    @Override
    public void creat(Numbers numbers) {
        numbers.setId(getId());
        map.put(numbers.getId(), numbers);
    }
    @Override
    public void update(Numbers number) {
        if (map.containsKey(number.getId())) {
            map.put(number.getId(), number);
        }
    }
    @Override
    public Numbers getById(Integer id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }
        return null;
    }
    @Override
    public void deleteById(Integer id) {
        map.remove(id);
    }
}
