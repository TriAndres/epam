package ru.practicum.lessonA.password.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Password {
    private Long id;
    private String login;
    private String password;
    private Boolean registration;
    private String name;
    private String time;
    private Integer interval;
}