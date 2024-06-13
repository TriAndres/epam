package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.List;

/*
10. Числа-палиндромы,значения которых в прямом и обратном порядке совпадают.
 */
public class Lesson10 extends LessonB {
    public Lesson10(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("10. Числа-палиндромы,значения которых в прямом и обратном порядке совпадают.");
        show(10, numberMeneger.getNumberList());

    }

    @Override
    public void show(int length, List<Number> numbersList) {
        int count = 0;
        for (Number n : numbersList) {
            String num1 = String.valueOf(n.getNum());
            String num2 = new StringBuilder(num1).reverse().toString();
            if (num1.equals(num2)) {
                System.out.print(n.getNum() + " ");
                count++;
                if (count == length) {
                    System.out.println();
                    count = 0;
                }
            }
        }
        System.out.println();
    }
}
