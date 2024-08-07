package ru.practiicum.number.model;

import java.util.Collection;
import java.util.Random;

public interface Manager {
    int getId();

    Collection<Number> getListNumbers();

    void save(Number number);

    void update(Number number);

    Number getById(int id);

    void deleteById(int id);

    void clear();

    void setListNumRandom(int size, int from, int to);
}
