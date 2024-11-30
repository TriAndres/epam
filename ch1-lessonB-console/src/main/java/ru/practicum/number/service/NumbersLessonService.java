package ru.practicum.number.service;

import ru.practicum.number.file.NumbersFile;
import ru.practicum.number.model.Numbers;

import java.util.Collection;

/*
Ввести с консоли n целых чисел. На консоль вывести:
1. Четные и нечетные числа.
2. Наибольшее и наименьшее число.
3. Числа, которые делятся на 3 или на 9.
4. Числа, которые делятся на 5 и на 7.
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
        show(numbersFile.findAll(),lineCount, i -> i % 2 == 0);
        System.out.println("\nНечётные:");
        show(numbersFile.findAll(),lineCount, i -> i % 2 != 0);
    }

    public void lesson3() {
        int lineCount = 10;
        System.out.println("3. Числа, которые делятся на 3 или на 9:");
        show(numbersFile.findAll(),lineCount, i -> i % 3 == 0);
    }

    public void lesson4() {
        int lineCount = 10;
        System.out.println("4. Числа, которые делятся на 5 и на 7.:");
        show(numbersFile.findAll(),lineCount, i -> i % 5 == 0 && i % 7 == 0);
    }

    private interface Action {
        boolean action(int flag);
    }

    private void show(Collection<Numbers> numbers, int lineCount, Action action) {
        int count = 0;
        int countAll = 0;
        System.out.println("id/numbers");
        for (Numbers number : numbers) {
            if (action.action(number.getNum())) {
                System.out.print("\t" + number.getId() + "/" + number.getNum());
                count++;
                countAll++;
                if (count == lineCount) {
                    System.out.println();
                    count = 0;
                }
            }
        }
        if (countAll == 0) {
            System.out.println("Список пуст.");
        }
    }

}
