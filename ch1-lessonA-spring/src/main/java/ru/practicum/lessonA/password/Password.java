package ru.practicum.lessonA.password;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Password {
    private Long id;
    private String name;
    private String password;
    private String login;
    private LocalDateTime time;
}