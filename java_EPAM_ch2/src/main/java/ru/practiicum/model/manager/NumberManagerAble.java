package ru.practiicum.model.manager;

import ru.practiicum.model.number.Numbers;

import java.util.List;

public interface NumberManagerAble {

    List<Numbers> getNumbers();

    void creat(Numbers numbers);

    void update(Numbers number);

    Numbers getById(Integer id);

    void deleteById(Integer id);
}