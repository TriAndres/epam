package ru.practicum.lessonA.model.lesson2;

import ru.practicum.lessonA.file.LessonFile;

import java.util.ArrayList;
import java.util.Scanner;

//2. Отобразить в окне консоли аргументы командной строки в обратном по-
//рядке.
public class ArgumentService {
    private final ArgumentRepository argumentRepository;
    private final LessonFile lessonFile;
    private final String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\lesson2\\ArgumentFile.txt";
    private final Scanner scanner = new Scanner(System.in);

    public ArgumentService() {
        argumentRepository = new ArgumentRepository();
        lessonFile = new LessonFile();
    }

    public static void main(String[] args) {
        new ArgumentService().game();
    }

    public void game() {
        System.out.println("2. Отобразить в окне консоли аргументы командной строки в обратном порядке");
        while (true) {
            String line = menu();
            if (line.equals("0")) break;
            String reverseLine = reverse(line);
            String result = "Ввели= " + line + ", реверс= " + reverseLine;
            argumentRepository.create(new Argument(result));
            lessonFile.writer(file, getArgumentAll());
            System.out.println(result);
        }
        argumentShowAll();
        System.out.println("Выход из программы.");
    }

    private String menu() {
        System.out.println("\n\tВыбирите действие:" +
                "\n\tВведите аргумент" +
                "\n\t0 для выхода.");
        return scanner.next();
    }

    public String reverse(String reverseLine) {
        return new StringBuffer().append(reverseLine).reverse().toString();
    }

    public ArrayList<String> getArgumentAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Argument argument : argumentRepository.getArgumentAll()) {
            arrayList.add(argument.getArgument());
        }
        return arrayList;
    }

    private void argumentShowAll() {
        System.out.println("Вывод списка.");
        for (String argument : getArgumentAll()) {
            System.out.println(argument);
        }
    }
}
