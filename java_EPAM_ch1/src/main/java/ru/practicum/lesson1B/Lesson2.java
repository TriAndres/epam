package ru.practicum.lesson1B;

import ru.practicum.number.NumberMeneger;
import ru.practicum.number.Number;

import java.util.Comparator;

/*
2. Наибольшее и наименьшее число.
 */
public class Lesson2 extends LessonB {

    public Lesson2(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        String max = numberMeneger.getNumberList().stream().max(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.getNum() - o2.getNum();
            }
        }).toString();
        System.out.println("Наибольшее число:\n" + max);

        String min = numberMeneger.getNumberList().stream().min(new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.getNum() - o2.getNum();
            }
        }).toString();
        System.out.println("Наименьшее число:\n" + min);
    }
}
