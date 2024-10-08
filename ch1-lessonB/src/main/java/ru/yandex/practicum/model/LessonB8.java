package ru.yandex.practicum.model;

import ru.yandex.practicum.number.ManageNumber;
import ru.yandex.practicum.number.Number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonB8 extends LessonB {
    public LessonB8(ManageNumber manageNumber) {
        super(manageNumber);
    }

    @Override
    public void game() {
        System.out.println("8. Числа в порядке убывания частоты встречаемости чисел.");
        numAllShow(20, 1, 50, 5);
        System.out.println("Частоты встречаемости чисел:");
        numSorted(manageNumber.getNumberList());
        manageNumber.getNumberList().clear();
    }

    private void numSorted(List<Number> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Number number1 : list) {
            if (!map.containsKey(number1.getValue())) {
                map.put(number1.getValue(), 1);
            } else {
                map.put(number1.getValue(), map.get(number1.getValue()) + 1);
            }
        }
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey((a, b) -> b - a))
                .forEach(System.out::println);
    }
}