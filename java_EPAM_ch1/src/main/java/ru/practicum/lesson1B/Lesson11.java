package ru.practicum.lesson1B;

import ru.practicum.number.Number;
import ru.practicum.number.NumberMeneger;

import java.util.List;

/*
11. Элементы, которые равны полусумме соседних элементов
 */
public class Lesson11 extends LessonB {
    public Lesson11(NumberMeneger numberMeneger) {
        super(numberMeneger);
    }

    @Override
    public void game() {
        showNumbers();
        System.out.println("11. Элементы, которые равны полусумме соседних элементов");
        show(10, numberMeneger.getNumberList());
    }

    @Override
    public void show(int length, List<Number> numbersList) {
        int count = 0;
        for (int i = 1; i < numbersList.size() - 1; i++) {
            if (numbersList.get(i).getNum() ==
                    (numbersList.get(i - 1).getNum() + numbersList.get(i + 1).getNum())/2) {
                System.out.print(numbersList.get(i).getNum() + " ");
                count++;
                if (count == length) {
                    System.out.println();
                    count = 0;
                }
            }
        }
    }
}
