package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.List;

/*
6. Простые числа.
 */
public class Lesson6 extends LessonB {
    public Lesson6(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("6. Простые числа.");
        show(10, numberMeneger.getNumberList());
    }

    @Override
    public void show(int length, List<Number> numbersList) {
        int count = 0;
        for (Number number : numbersList) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.floor(Math.sqrt(number.getNum())) ; i++) {
                if (number.getNum() != i) {
                    if (number.getNum() % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.print(number.getNum() + "\t");
                count++;
                if (count == length) {
                    System.out.println();
                    count = 0;
                }
            }
        }
    }
}