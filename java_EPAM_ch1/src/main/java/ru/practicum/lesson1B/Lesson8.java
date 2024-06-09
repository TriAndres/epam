package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.HashMap;
import java.util.Map;

/*
8. Числа в порядке убывания частоты встречаемости чисел.
*/
public class Lesson8 extends LessonB {
    public Lesson8(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("8. Числа в порядке возрастание частоты встречаемости чисел.");
        Map<Integer, Integer> map = new HashMap<>();
        for (Number number : numberMeneger.getNumberList()) {
            map.put(number.getNum(), map.getOrDefault(number.getNum(), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}