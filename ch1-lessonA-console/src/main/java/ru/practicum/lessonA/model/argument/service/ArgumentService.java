package ru.practicum.lessonA.model.argument.service;

import ru.practicum.lessonA.model.argument.file.ArgumentFile;
import ru.practicum.lessonA.model.argument.model.Argument;

import java.util.Scanner;

import static ru.practicum.lessonA.model.argument.file.ArgumentFile.loadFromFile;

public class ArgumentService {
    private final ArgumentFile argumentFile;
    private final Scanner scanner = new Scanner(System.in);

    public ArgumentService() {
        String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\argument\\file\\ArgumentFile.txt";
        this.argumentFile = loadFromFile(file);
    }

    public static void main(String[] args) {
        ArgumentService service = new ArgumentService();
        service.hello();
        service.reverse();
    }

    public void hello() {
        System.out.println("Введите ваше имя.");
        Argument name = new Argument(getNextId(), scanner.next());
        argumentFile.create(name);
        System.out.println(name.getArgument() + ", Приветствую вас!");
    }

    public void reverse() {
        System.out.println("Введите аргумент.");
        Argument name = new Argument(getNextId(), scanner.next());
        argumentFile.create(name);
        System.out.println(new StringBuffer().append(name.getArgument()).reverse());
    }


    private Long getNextId() {
        long currentMaxId = argumentFile.getArgumentAll()
                .stream()
                .mapToLong(Argument::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
