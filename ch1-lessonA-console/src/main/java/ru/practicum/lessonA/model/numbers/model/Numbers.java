package ru.practicum.lessonA.model.numbers.model;

public class Numbers {
    private Long id;
    private Integer num;

    public Numbers(Long id, Integer num) {
        this.id = id;
        this.num = num;
    }

    public Numbers(Integer num) {
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}