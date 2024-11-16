package ru.practicum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        //while (true) {
            t.setListNumber();
            t.setListNumber();
        //}
    }

    public void setListNumber() {
        int size = 0;
        int from = 0;
        int to = 0;
        ArrayList<Number> list = new ArrayList<>();
        System.out.println("Введите в формате количество/от/до случайных чисел:\n" +
                "пример:100/30/99");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text;
            String[] line = null;
            while ((text = br.readLine()) != null) {
                line = text.split("/");
                if (line.length == 3) {
                    if (Integer.parseInt(line[0]) > 0 && Integer.parseInt(line[1]) > 0 && Integer.parseInt(line[2]) > 0) {
                        size = Integer.parseInt(line[0]);
                        from = Integer.parseInt(line[1]);
                        to = Integer.parseInt(line[2]);
                    }
                    System.out.println("запись");
                    for (int i = 1; i <= size; i++) {
                        list.add(from + new Random().nextInt(to - from));
                    }
                    for (Number number : list) {
                        System.out.println(number.intValue());
                    }

                }
                System.out.println("введите заново");
            }


        } catch (IOException e) {
            System.out.println();
        }

    }

}
