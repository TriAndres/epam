package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.List;

/*
3. Числа, которые делятся на 3 или на 9.
 */
public class Lesson3 extends LessonB {

    public Lesson3(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("Числа, делятся на 3 или на 9.");
        List<Number> numberList = numberMeneger.getNumberList().stream().filter(a -> a.getNum() % 3 == 0 || a.getNum() % 9 == 0).toList();
        show(10, numberList);
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
