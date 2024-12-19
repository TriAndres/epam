package ru.practicum.console;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer getInteger(int size) {
        int num = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num > size) {
                    break;
                } else {
                    scanner.nextLine();
                }
            }
        }
        return num;
    }

    public static Double getDouble() {
        double num = 0;
        while (true) {
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
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