package ru.practicum.model.numbers.service;

import ru.practicum.model.numbers.file.NumbersFile;

public class NumbersLessonService {
    private final NumbersFile numbersFile;

    public NumbersLessonService(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    public void lesson1() {
        System.out.println("1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
    }

    public void lesson2() {
        System.out.println("2. Упорядочить и вывести числа в порядке возрастания (убывания) значений\n" +
                " их длины.");
    }

    public void lesson3() {
        System.out.println("3. Вывести на консоль те числа, длина которых меньше (больше) средней,\n" +
                " а также длину.");
    }

    public void lesson4() {
        System.out.println("4. Найти число, в котором число различных цифр минимально. Если таких\n" +
                " чисел несколько, найти первое из них.");
    }

    public void lesson5() {
        System.out.println("5. Найти количество чисел, содержащих только четные цифры, а среди них —\n" +
                " количество чисел с равным числом четных и нечетных цифр.");
    }

    public void lesson6() {
        System.out.println("6. Найти число, цифры в котором идут в строгом порядке возрастания. Если\n" +
                " таких чисел несколько, найти первое из них.");
    }

    public void lesson7() {
        System.out.println("7. Найти число, состоящее только из различных цифр. Если таких чисел не-\n" +
                " сколько, найти первое из них.");
    }

    public void lesson8() {
        System.out.println("8. Среди чисел найти число-палиндром. Если таких чисел больше одного,\n" +
                " найти второе.");
    }

    public void lesson9() {
        System.out.println("9. Найти корни квадратного уравнения. Параметры уравнения передавать\n" +
                " с командной строкой.");
    }
}