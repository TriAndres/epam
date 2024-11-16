package ru.practicum.lessonA.numbers.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Numbers {
    private Long id;
    private Integer num;
}