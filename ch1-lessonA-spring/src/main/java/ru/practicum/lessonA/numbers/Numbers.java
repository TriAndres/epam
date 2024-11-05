package ru.practicum.lessonA.numbers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Numbers {
    private Long id;
    private Integer number;
}