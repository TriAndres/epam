package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.List;

/*
7. Отсортированные числа в порядке возрастания и убывания.
 */
public class Lesson7 extends LessonB {
    public Lesson7(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("7. Отсортированные числа в порядке возрастания и убывания.");
        System.out.println("По возрастанию:");
        numberMeneger.getNumberList().sort((o1,o2) -> o1.getNum() - o2.getNum());
        show(10, numberMeneger.getNumberList());
        System.out.println("\nПо убыванию:");
        numberMeneger.getNumberList().sort((o1,o2) -> o2.getNum() - o1.getNum());
        show(10, numberMeneger.getNumberList());
    }

    @Override
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
