package ru.practicum.lessonA.model.argument;

public class Argument {
    private Long id;
    private String argument;

    public Argument(Long id, String argument) {
        this.id = id;
        this.argument = argument;
    }

    public Argument(String argument) {
        this.argument = argument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
