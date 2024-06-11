package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.List;

/*
9. «Счастливые» числа.
**Счастливым будет считаться такое число из шести цифр, в котором сумма левых трех цифр равна сумме правых трех**
 */
public class Lesson9 extends LessonB {
    public Lesson9(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("9. «Счастливые» числа(из 6 цифр).");
        show(10, numberMeneger.getNumberList());
    }

    @Override
    public void show(int length, List<Number> numbersList) {
        int count = 0;
        for (Number n : numbersList) {
            String[] num = String.valueOf(n.getNum()).split("");
            if (num.length == 6) {
                int sum1 = Integer.parseInt(num[0]) + Integer.parseInt(num[1]) + Integer.parseInt(num[2]);
                int sum2 = Integer.parseInt(num[3]) + Integer.parseInt(num[4]) + Integer.parseInt(num[5]);
                if (sum1 == sum2) {
                    System.out.print(n.getNum() + "\t");
                    count++;
                    if (count == length) {
                        System.out.println();
                        count = 0;
                    }
                }
            }
        }
        System.out.println();
    }

}
