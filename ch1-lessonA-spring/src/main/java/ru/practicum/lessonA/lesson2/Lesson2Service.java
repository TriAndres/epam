package ru.practicum.lessonA.lesson2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.lessonA.lesson2.model.Lesson2;
import ru.practicum.lessonA.lesson2.model.ReversOrder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static ru.practicum.lessonA.lesson2.model.ReversOrder.NOT_REVERSE;
import static ru.practicum.lessonA.lesson2.model.ReversOrder.REVERSE;


@Service
@RequiredArgsConstructor
public class Lesson2Service {
    private final Lesson2Repository lesson2Repository;

    public Lesson2 lesson2Create(Lesson2 argument) {
        return lesson2Repository.lesson2Current(argument);
    }

    /*
    2. Отобразить в окне консоли аргументы командной строки в обратном по-
       рядке.
     */
    public Collection<String> lesson2ReverseFindAll(ReversOrder order) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (order.equals(NOT_REVERSE)) {
            for (Lesson2 argument : lesson2Repository.lesson2FindAll()) {
                arrayList.add(argument.getId() + " no_revers= " + argument.getName());
            }
            return arrayList;
        } else if (order.equals(REVERSE)) {
            for (Lesson2 argument : lesson2Repository.lesson2FindAll()) {
                arrayList.add(argument.getId() + " reverse= " + new StringBuffer().append(argument.getName()).reverse());
            }
            return arrayList;
        }
        return arrayList;
    }

    public Optional<Lesson2> lesson2FindById(long lesson2Id) {
        return lesson2Repository.lesson2FindAll()
                .stream()
                .filter(id -> id.getId() == lesson2Id)
                .findFirst();
    }
}
