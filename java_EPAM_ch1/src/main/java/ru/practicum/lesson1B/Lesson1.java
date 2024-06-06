package ru.practicum.lesson1B;

import ru.practicum.number.NumberMeneger;
import ru.practicum.number.Number;

import java.util.List;

/*
1. Четные и нечетные числа.
 */
public class Lesson1 extends LessonB {


    public Lesson1(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("Чётные числа:");
        List<Number> numbersList1 = numberMeneger.getNumberList().stream().filter(a -> a.getNum() % 2 == 0).toList();
        show(10, numbersList1);

        System.out.println("\nНечетные числа:");
        List<Number> numbersList2 = numberMeneger.getNumberList().stream().filter(a -> a.getNum() % 2 != 0).toList();
        show(10, numbersList2);
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
