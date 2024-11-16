package ru.practicum.lessonA.console;

import java.util.Scanner;

public class Console {
    private final static Scanner scanner = new Scanner(System.in);

    public static long getLong() {
        long num = 0L;
        while (true) {
            if (scanner.hasNextLong()) {
                num = scanner.nextLong();
                break;
            }
            if (scanner.hasNextLine()){
                scanner.nextLine();
            }
        }
        return num;
    }

    public static int getInteger() {
        int num = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
            }
        }
        return num;
    }

    public static String getString() {
        return scanner.next();
    }
}