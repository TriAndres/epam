package ru.practicum.lessonA.model.numbers.model;

public class Numbers {
    private Long id;
    private Long num;

    public Numbers(Long id, Long num) {
        this.id = id;
        this.num = num;
    }

    public Numbers(Long num) {
        this.num = num;
    }

    public Numbers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}