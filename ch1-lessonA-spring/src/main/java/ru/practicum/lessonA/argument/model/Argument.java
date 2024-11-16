package ru.practicum.lessonA.argument.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Argument {
    private Long id;
    private String argument;
}