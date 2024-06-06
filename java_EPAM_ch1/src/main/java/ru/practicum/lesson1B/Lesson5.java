package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.List;

/*
5. Все трехзначные числа, в десятичной записи которых нет одинаковых
цифр.
 */
public class Lesson5 extends LessonB {

    public Lesson5(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("5. Все трехзначные числа, в десятичной записи" +
                " которых нет одинаковых цифр.");
        show(10, numberMeneger.getNumberList());
    }

    @Override
    public void show(int length, List<Number> numbersList) {
        int count = 0;
        for (Number number : numberMeneger.getNumberList()) {
            String n = Integer.toString(number.getNum());
            if (n.length() == 3) {
                String[] num = n.split("");
                if (!num[0].equals(num[1]) && !num[1].equals(num[2]) && !num[2].equals(num[0])) {
                    System.out.print(number.getNum() + " ");
                    count++;
                    if (count == length) {
                        System.out.println();
                        count = 0;
                    }
                }
            }
        }
    }
}
