package ru.practicum.factory;

import ru.practicum.lesson1B.*;
import ru.practicum.number.NumberMeneger;

public class FactoryB implements Factory{
    private LessonB lessonB;
    private final NumberMeneger numberMeneger;

    public FactoryB(NumberMeneger numberMeneger) {
        this.numberMeneger = numberMeneger;
    }

    public void task1() {
        lessonB = new Lesson1(numberMeneger);
        lessonB.game();
    }
    public void task2() {
        lessonB = new Lesson2(numberMeneger);
        lessonB.game();
    }
    public void task3() {
        lessonB = new Lesson3(numberMeneger);
        lessonB.game();
    }
    public void task4() {
        lessonB = new Lesson4(numberMeneger);
        lessonB.game();
    }
    public void task5() {
        lessonB = new Lesson5(numberMeneger);
        lessonB.game();
    }
    public void task6() {
        lessonB = new Lesson6(numberMeneger);
        lessonB.game();
    }
    public void task7() {
        lessonB = new Lesson7(numberMeneger);
        lessonB.game();
    }
    public void task8() {
        lessonB = new Lesson8(numberMeneger);
        lessonB.game();
    }
    public void task9() {
        lessonB = new Lesson9(numberMeneger);
        lessonB.game();
    }
    public void task10() {
        lessonB = new Lesson10(numberMeneger);
        lessonB.game();
    }
    public void task11() {
        lessonB = new Lesson11(numberMeneger);
        lessonB.game();
    }

    public void getFile() {
        numberMeneger.getFile();
    }
}