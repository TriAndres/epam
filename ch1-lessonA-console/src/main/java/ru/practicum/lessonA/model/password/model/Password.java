package ru.practicum.lessonA.model.password.model;

import java.time.LocalDateTime;

public class Password {
    private Long id;
    private String login;
    private String password;
    private String name;
    private LocalDateTime time;
    private Integer interval;

    public Password(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Password(Long id, String login, String password, String name, LocalDateTime time, Integer interval) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.time = time;
        this.interval = interval;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }
}
