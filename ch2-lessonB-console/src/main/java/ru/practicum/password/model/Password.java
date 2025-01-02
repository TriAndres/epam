package ru.practicum.password.model;

public class Password {
    private Long id;
    private String login;
    private String password;
    private String registration;
    private String name;
    private String localDateTame;
    private String Interval;

    public Password() {
    }

    public Password(Long id,
                    String login,
                    String password,
                    String registration,
                    String name,
                    String localDateTame,
                    String interval) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.registration = registration;
        this.name = name;
        this.localDateTame = localDateTame;
        Interval = interval;
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalDateTame() {
        return localDateTame;
    }

    public void setLocalDateTame(String localDateTame) {
        this.localDateTame = localDateTame;
    }

    public String getInterval() {
        return Interval;
    }

    public void setInterval(String interval) {
        Interval = interval;
    }
}