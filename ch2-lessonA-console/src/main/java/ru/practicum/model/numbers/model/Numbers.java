package ru.practicum.model.numbers.model;

public class Numbers {
    private long id;
    private int number;

    public Numbers(int number) {
        this.number = number;
    }

    public Numbers(long id, int number) {
        this.id = id;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return id + "/" + number + "\n";
    }
}