package ru.practicum.lessonA.model.lesson1;

public class UserController {
    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public UserService user() {
        return userService;
    }
}