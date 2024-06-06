package ru.practicum.factory;
import ru.practicum.lesson1A.*;

public class FactoryA implements Factory{
    private LessonA lesson;

    public void task1() {
        lesson = new Lesson1();
        lesson.game();
    }
    public void task2() {
        lesson = new Lesson2();
        lesson.game();
    }
    public void task3() {
        lesson = new Lesson3();
        lesson.game();
    }
    public void task4() {
        lesson = new Lesson4();
        lesson.game();
    }
    public void task5() {
        lesson = new Lesson5();
        lesson.game();
    }
    public void task6() {
        lesson = new Lesson6();
        lesson.game();
    }
}
