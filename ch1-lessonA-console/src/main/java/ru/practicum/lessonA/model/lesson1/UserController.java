package ru.practicum.lessonA.model.lesson1;

import ru.practicum.lessonA.file.LessonFile;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    private final String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\lesson1\\UserFile.txt";
    private final LessonFile us;
    private Scanner scanner;
    private ArrayList<String> arrayList;

    public UserController() {
        us = new LessonFile();
        scanner = new Scanner(System.in);
        arrayList = new ArrayList<>();
    }

    public void createHello() {
        System.out.println("1 Приветствовать любого пользователя при вводе его имени через командную строку");
        while (true) {
            String name = menu();
            if (name.equals("0")) break;
            String line = name + ", Вас приветствую!";
            arrayList.add(line);
            us.writer(file, arrayList);
            System.out.println(line);
        }
        System.out.println("Вывод списка:");
        usersShowAll();
        System.out.println("Вышли из программы");
    }

    private String menu() {
        System.out.println("\n\tВыберите действие:" +
                "\n\tВведите ваше имя" +
                "\n\t0 для выхода");
        return scanner.next();
    }

    private void usersShowAll() {
        for (String string : arrayList) {
            System.out.println(string);
        }
    }
}