package ru.practicum.console;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.next();
    }

    public static Integer getInteger() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
