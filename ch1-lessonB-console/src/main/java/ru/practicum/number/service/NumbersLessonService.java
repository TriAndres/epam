package ru.practicum.number.service;

import ru.practicum.number.file.NumbersFile;
import ru.practicum.number.model.Numbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class NumbersLessonService {
    private final NumbersFile numbersFile;

    public NumbersLessonService(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    public void lesson1() {
        int lineCount = 10;
        System.out.println("1. Четные и нечетные числа.\nЧётные:");
        show(numbersFile.findAll()
                        .stream()
                        .filter(i -> i.getNum() % 2 == 0)
                        .toList()
                , lineCount);
        System.out.println("\nНечётные:");
        show(numbersFile.findAll()
                        .stream()
                        .filter(i -> i.getNum() % 2 != 0)
                        .toList()
                , lineCount);
    }

    public void lesson2() {
        System.out.println("2. Наибольшее и наименьшее число.");
        System.out.println("Наибольшее число:\n" + numbersFile.findAll()
                .stream()
                .max((x, y) -> Integer.compare(x.getNum(), y.getNum()))
                .get().getNum());
        System.out.println("Наименьшее число:\n" + numbersFile.findAll()
                .stream()
                .min((x, y) -> Integer.compare(x.getNum(), y.getNum()))
                .get().getNum());
    }

    public void lesson3() {
        int lineCount = 10;
        System.out.println("3. Числа, которые делятся на 3 или на 9:");
        show(numbersFile.findAll()
                        .stream()
                        .filter(i -> i.getNum() % 3 == 0)
                        .toList()
                , lineCount);
    }

    public void lesson4() {
        int lineCount = 10;
        System.out.println("4. Числа, которые делятся на 5 и на 7.:");
        show(numbersFile.findAll().stream()
                        .filter(i -> i.getNum() % 5 == 0 && i.getNum() % 7 == 0)
                        .toList()
                , lineCount);
    }

    public void lesson5() {
        System.out.println("5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.");
        int lineCount = 10;
        show(numbersFile.findAll()
                        .stream()
                        .filter(i -> {
                            String[] line = String.valueOf(i.getNum()).split("");
                            return !line[0].equals(line[1]) &&
                                    !line[1].equals(line[2]) &&
                                    !line[2].equals(line[0]) &&
                                    String.valueOf(i.getNum()).length() == 3;
                        }).toList()
                , lineCount);
    }

    public void lesson6() {
        System.out.println("6. Простые числа.(Все от однозначного до трехзначного числа)");
        int lineCount = 10;
        show(numbersFile.findAll()
                        .stream()
                        .filter(i -> {
                            for (int k = 2; k <= Math.sqrt(i.getNum()); k++) {
                                if (i.getNum() % k == 0) {
                                    return false;
                                } else if (String.valueOf(i.getNum()).length() > 3) {
                                    return false;
                                }
                            }
                            return true;
                        }).toList()
                , lineCount);
    }

    public void lesson7() {
        System.out.println("7. Отсортированные числа в порядке возрастания и убывания.");
        int lineCount = 10;
        System.out.println("В порядке возрастания:");
        show(numbersFile.findAll()
                        .stream().sorted((a, b) -> a.getNum() - b.getNum())
                        .toList()
                , lineCount);
        System.out.println("\nВ порядке убывания:");
        show(numbersFile.findAll()
                        .stream().sorted((a, b) -> b.getNum() - a.getNum())
                        .toList()
                , lineCount);
    }

    public void lesson8() {
        System.out.println("8. Числа в порядке убывания частоты встречаемости чисел.");
        Map<Integer, Integer> map = new HashMap<>();
        for (Numbers numbers : numbersFile.findAll()) {
            if (!map.containsKey(numbers.getNum())) {
                map.put(numbers.getNum(), 1);
            } else {
                map.put(numbers.getNum(), map.get(numbers.getNum()) + 1);
            }
        }
        map.entrySet().stream().sorted((a, b) -> b.getKey() - a.getKey()).forEach(System.out::println);
    }

    public void lesson9() {
        System.out.println("9. «Счастливые» числа.");
    }

    public void lesson10() {
        System.out.println("10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.");
    }

    public void lesson11() {
        System.out.println("11. Элементы, которые равны полусумме соседних элементов.");
    }

    private void show(List<Numbers> numbers, int lineCount) {
        int count = 0;
        int countAll = 0;
        System.out.println("id/numbers");
        for (Numbers number : numbers) {
            System.out.print("\t" + number.getId() + "/" + number.getNum());
            count++;
            countAll++;
            if (count == lineCount) {
                System.out.println();
                count = 0;
            }
        }
        if (countAll == 0) {
            System.out.println("Список пуст.");
        }
    }
}