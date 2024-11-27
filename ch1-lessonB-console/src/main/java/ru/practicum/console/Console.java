package ru.practicum.console;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer getInteger(int line) {
        int num = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num > line) {
                    break;
                }
                System.out.println("Цифра должна быть больше > " + line);
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                System.out.println("Введите цифру:");
            }
        }
        return num;
    }
}
