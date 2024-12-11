package ru.practicum.numbers.service;

import ru.practicum.numbers.file.NumbersFile;
import ru.practicum.numbers.model.Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumbersLessonService {
    private final NumbersFile numbersFile;

    public NumbersLessonService(NumbersFile numbersFile) {
        this.numbersFile = numbersFile;
    }

    public void lesson1() {
        System.out.println("1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        List<Numbers> list = numbersFile.findAll()
                .stream()
                .sorted((a, b) -> a.getNumber() - b.getNumber())
                .toList();
        System.out.println("Вывод: id/number/length");
        System.out.println("Cамое короткое число: " + list.get(0).getId() + "/" + list.get(0).getNumber() +
                "/" + String.valueOf(list.get(0).getNumber()).length());
        System.out.println("Cамое длинное число: " + list.get(list.size() - 1).getId() + "/" + list.get(list.size() - 1).getNumber() +
                "/" + String.valueOf(list.get(list.size() - 1).getNumber()).length());
    }

    public void lesson2() {
        System.out.println("2. Упорядочить и вывести числа в порядке возрастания (убывания) значений\n" +
                " их длины.");
        int lineSize = 10;
        System.out.println("В порядке возрастания значений:");
        show(numbersFile.findAll()
                        .stream()
                        .sorted((a, b) -> a.getNumber() - b.getNumber())
                        .toList()
                , lineSize);
        System.out.println("\nВ порядке убывания значений:");
        show(numbersFile.findAll()
                        .stream()
                        .sorted((a, b) -> b.getNumber() - a.getNumber())
                        .toList()
                , lineSize);
    }

    public void lesson3() {
        System.out.println("3. Вывести на консоль те числа, длина которых меньше (больше) средней,\n" +
                " а также длину.");
        int lineSize = 10;
        int sum = numbersFile.findAll().stream().mapToInt(Numbers::getNumber).sum();
        System.out.println("Числа меньше средней:");
        show(numbersFile.findAll()
                        .stream()
                        .filter(i -> i.getNumber() > sum / numbersFile.findAll().size())
                        .toList()
                , lineSize);
        System.out.println("\nЧисла больше средней:");
        show(numbersFile.findAll()
                        .stream()
                        .filter(i -> i.getNumber() < sum / numbersFile.findAll().size())
                        .toList()
                , lineSize);
    }

    private void show(List<Numbers> list, int lineSize) {
        int count = 0;
        System.out.println("Вывод: id/number/length");
        for (Numbers numbers : list) {
            System.out.print("\t" + numbers.getId() + "/" + numbers.getNumber() + "/" + String.valueOf(numbers.getNumber()).length());
            count++;
            if (count == lineSize) {
                System.out.println();
                count = 0;
            }
        }
    }

    public void lesson4() {
        System.out.println("4. Найти число, в котором число различных цифр минимально. Если таких\n" +
                " чисел несколько, найти первое из них.(число из 6 цифр)");
        class Num {
            private final Long id;
            private final Integer num;
            private final Integer various;

            public Num(Long id, Integer num, Integer various) {
                this.id = id;
                this.num = num;
                this.various = various;
            }

            public Long getId() {
                return id;
            }

            public Integer getNum() {
                return num;
            }

            public Integer getVarious() {
                return various;
            }

            @Override
            public String toString() {
                return id + "/" + num + "/" + various;
            }
        }

        List<Num> nums = new ArrayList<>();
        for (Numbers numbers : numbersFile.findAll()) {
            String[] line = String.valueOf(numbers.getNumber()).split("");
            Map<Integer, Integer> map = new HashMap<>();
            for (String s : line) {
                if (!map.containsKey(Integer.parseInt(s))) {
                    map.put(Integer.parseInt(s), 1);
                } else {
                    map.put(Integer.parseInt(s), map.get(Integer.parseInt(s)) + 1);
                }
            }
            nums.add(new Num(numbers.getId(), numbers.getNumber(), map.size()));
        }
        System.out.println("id/number/various");
        int size = 6;
        List<Num> nums1 = nums
                .stream()
                .filter(i -> String.valueOf(i.getNum()).length() == size)
                .sorted((a, b) -> b.getNum() - a.getNum())
                .sorted((a, b) -> a.getVarious() - b.getVarious()).toList();
        System.out.println(nums1.get(0).toString());
    }

    public void lesson5() {
        System.out.println("5. Найти количество чисел, содержащих только четные цифры, а среди них —\n" +
                " количество чисел с равным числом четных и нечетных цифр.");
        int lineSize = 10;
        show(numbersFile.findAll()
                .stream()
                .filter((i) -> {
                            String[] line = String.valueOf(i.getNumber()).split("");
                            int sum1 = 0;
                            int sum2 = 0;
                            for (String s : line) {
                                if (Integer.parseInt(s) % 2 == 0) {
                                    ++sum1;
                                }
                                if (Integer.parseInt(s) % 2 != 0) {
                                    ++sum2;
                                }
                            }
                            return sum1 == sum2 && i.getNumber() % 2 == 0;
                        }
                )
                .toList()
                , lineSize
        );
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