package ru.practicum.lessonA.password.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Password {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "registration")
    private Boolean registration;
    @Column(name = "name")
    private String name;
    @Column(name = "localDateTime")
    private String localDateTime;
    @Column(name = "interval")
    private Integer interval;
}