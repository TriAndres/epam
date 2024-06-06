package ru.practicum.lesson1A;

import ru.practicum.console.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
6. Вывести фамилию разработчика, дату и время получения задания, а также
дату и время сдачи задания.
 */
public class Lesson6 implements LessonA {
    private final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    private final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd 10:00");
    private LocalDateTime localDateTime;
    private String lastName;
    private Scanner scanner = new Scanner(System.in);

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void game() {
        System.out.println("\nВведите ваше фамилию");
        setLastName(Console.getString());
        localDateTime = LocalDateTime.now();
        String dataTime1 = localDateTime.format(formatter1);
        System.out.println("Разработчик " + getLastName() + ", получил задание, " + dataTime1);
        System.out.println("Через сколько дней сделаете задание?");
        int day = Console.getInteger();
        String dataTime2 = localDateTime.plusDays(day).format(formatter2);
        System.out.println("Разработчик " + getLastName() + ", выполнит задание к " + dataTime2);
    }
}