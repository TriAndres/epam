package ru.practicum.number;

import ru.practicum.exseption.MyException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberMeneger {
    private  List<Number> numberList = new ArrayList<>();
    private final String path = "src\\main\\java\\ru\\practicum\\number\\res.txt";

    public  int getId() {
        return numberList.size();
    }

    public List<Number> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Number> numberList) {
        this.numberList = numberList;
    }

    public void create(Number number) {
        number.setId(numberList.size());
        numberList.add(number);
        setFile(numberList);
    }

    public Number getById(int id) {
        return numberList.get(id);
    }

    public void  clear() {
        numberList.clear();
    }

    public void getFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            List<Number> arrayList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(getNumberFile(line));
            }
            setNumberList(arrayList);
        } catch (IOException e) {
            throw new MyException("Ошибка при чтении", e);
        }
    }

    public Number getNumberFile(String line) {
        String[] strings = line.split("/");
        return new Number(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
    }

    public void setFile(List<Number> numberList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,StandardCharsets.UTF_8))){
            for (Number number : numberList) {
                writer.write(setStringFile(number));
            }

        } catch (IOException e) {
            throw new MyException("Ошибка при записи", e);
        }
    }

    public String setStringFile(Number line) {
        return String.format("%d/%d\n",line.getId(),line.getNum());
    }

    public static void main(String[] args) {
        NumberMeneger m = new NumberMeneger();
        Scanner scanner = new Scanner(System.in);
        m.getFile();
        while (true) {
            System.out.println("Введите цифру или 0 для выхода:");
            int num = scanner.nextInt();
            if (num == 0) break;
            m.create(new Number(num));

            for (Number number : m.getNumberList()) {
                System.out.println(number);
            }
        }
    }
}
