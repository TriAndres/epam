package ru.yandex.practicum.number.controller;

public interface Controller {
    void getInitNum();

    void getListNumbers();

    void save();

    void update();

    void getById();

    void deleteById();

    void clear();

    void setListNumRandom();
}
