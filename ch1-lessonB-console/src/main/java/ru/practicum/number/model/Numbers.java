package ru.practicum.number.model;

public class Numbers {
    private Long id;
    private int num;

    public Numbers(int num) {
        this.num = num;
    }

    public Numbers(Long id, int num) {
        this.id = id;
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}