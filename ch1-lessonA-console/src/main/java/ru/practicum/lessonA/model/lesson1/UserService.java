package ru.practicum.lessonA.model.lesson1;

import ru.practicum.lessonA.file.LessonFile;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private final UserRepository userRepository;
    private final LessonFile us;
    private final String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\lesson1\\UserFile.txt";
    private Scanner scanner;

    public UserService() {
        userRepository = new UserRepository();
        us = new LessonFile();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new UserService().game();
    }

    public void game() {
        System.out.println("1 Приветствовать любого пользователя при вводе его имени через командную строку");
        while (true) {
            String name = menu();
            if (name.equals("0")) break;
            String line = name + ", Вас приветствую!";
            userRepository.create(new User(line));
            us.writer(file, getUserAll());
            System.out.println(line);
        }
        usersShowAll();
        System.out.println("Вышли из программы");
    }

    private String menu() {
        System.out.println("\n\tВыберите действие:" +
                "\n\tВведите ваше имя" +
                "\n\t0 для выхода");
        return scanner.next();
    }

    public ArrayList<String> getUserAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (User user : userRepository.getUserAll()) {
            arrayList.add(user.getName());
        }
        return arrayList;
    }

    private void usersShowAll() {
        System.out.println("Вывод списка:");
        for (String string : getUserAll()) {
            System.out.println(string);
        }
    }
}