package ru.practicum.lesson1B;

import ru.practicum.number.NumberMeneger;
import ru.practicum.number.Number;

import java.util.List;

public abstract class LessonB {
    protected final NumberMeneger numberMeneger;

    public LessonB(NumberMeneger numberMeneger) {
        this.numberMeneger = numberMeneger;
    }
    public void showNumbers() {
        int count = 0;
        int length = 10;
        System.out.println("Ввод:");
        for (Number numbers : numberMeneger.getNumberList()) {
            System.out.print(numbers.getNum() + "\t");
            count++;
            if (count == length) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println();
    }
    public abstract void game();
    public void show(int length, List<Number> numbersList){}
}
