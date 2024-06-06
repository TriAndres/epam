package ru.practicum.lesson1B;

import ru.practicum.number.NumberMeneger;
import ru.practicum.number.Number;

import java.util.List;


/*
4. Числа, которые делятся на 5 и на 7.
 */
public class Lesson4 extends LessonB {

    public Lesson4(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("Числа, делятся на 5 и на 7");
        List<Number> list = numberMeneger.getNumberList().stream().filter(i -> i.getNum() % 5 == 0 && i.getNum() % 7 == 0).toList();
        show(10, list);
    }

    public void show(int length,List<Number> numbersList) {
        int count = 0;
        for (Number numbers : numbersList) {
            System.out.print(numbers.getNum() + " ");
            count++;
            if (count == length) {
                System.out.println();
                count = 0;
            }
        }
    }
}
