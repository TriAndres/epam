package ru.practicum.number.service;

import ru.practicum.number.file.NumbersFile;
import ru.practicum.number.model.Numbers;
import java.util.List;

/*
Ввести с консоли n целых чисел. На консоль вывести:
5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
6. Простые числа.
7. Отсортированные числа в порядке возрастания и убывания.
8. Числа в порядке убывания частоты встречаемости чисел.
9. «Счастливые» числа.
10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.
11. Элементы, которые равны полусумме соседних элементов.
 */
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
                ,lineCount);
        System.out.println("\nНечётные:");
        show(numbersFile.findAll()
                .stream()
                .filter(i -> i.getNum() % 2 != 0)
                .toList()
                ,lineCount);
    }

    public void lesson3() {
        int lineCount = 10;
        System.out.println("3. Числа, которые делятся на 3 или на 9:");
        show(numbersFile.findAll()
                .stream()
                .filter(i -> i.getNum() % 3 == 0)
                .toList()
                ,lineCount);
    }

    public void lesson4() {
        int lineCount = 10;
        System.out.println("4. Числа, которые делятся на 5 и на 7.:");
        show(numbersFile.findAll().stream()
                .filter(i -> i.getNum() % 5 == 0 && i.getNum() % 7 == 0)
                .toList()
                ,lineCount);
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

}
