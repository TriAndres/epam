package ru.practicum.number;

public class Number {
    private int id;
    private int num;

    public Number(int num) {
        this.num = num;
    }

    public Number(int id, int num) {
        this.id = id;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "id=" + id + ", num=" + num;
    }
}
