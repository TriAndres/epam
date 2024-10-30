package ru.practicum.lessonA.lesson2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson2 {
    private Long id;
    private String name;

//    public Lesson2(String name) {
//        this.name = name;
//    }
}