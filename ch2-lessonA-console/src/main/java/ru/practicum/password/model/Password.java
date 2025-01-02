package ru.practicum.password.model;

import java.time.LocalDateTime;

public class Password {
    private Long id;
    private String login;
    private String password;
    private Boolean registration;
    private String name;
    //private LocalDateTime localDateTime;
    //private Integer interval;

    public Password() {
    }

    public Password(String login,
                    String password) {
        this.login = login;
        this.password = password;
    }

    public Password(Long id,
                    String login,
                    String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Password(Long id,
                    String login,
                    String password,
                    Boolean registration,
                    String name//,
                    //LocalDateTime localDateTime,
                    //Integer interval
                    ) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.registration = registration;
        this.name = name;
        //this.localDateTime = localDateTime;
        //this.interval = interval;
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

    public Boolean getRegistration() {
        return registration;
    }

    public void setRegistration(Boolean registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDateTime getLocalDateTime() {
//        return localDateTime;
//    }
//
//    public void setLocalDateTime(LocalDateTime localDateTime) {
//        this.localDateTime = localDateTime;
//    }
//
//    public Integer getInterval() {
//        return interval;
//    }
//
//    public void setInterval(Integer interval) {
//        this.interval = interval;
//    }
}
