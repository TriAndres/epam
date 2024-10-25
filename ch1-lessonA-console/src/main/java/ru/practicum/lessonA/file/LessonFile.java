package ru.practicum.lessonA.file;

import java.io.*;
import java.util.ArrayList;

public class LessonFile {

    public void writer(String file, ArrayList<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for (String s : list) {
                bw.write(s + "\n");
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public ArrayList<String> read(String file) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] row = line.split("\\s++\\s++");
                list.add(row[0]);
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return list;
    }
}