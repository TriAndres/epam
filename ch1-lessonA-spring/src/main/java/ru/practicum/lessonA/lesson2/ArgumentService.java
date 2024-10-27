package ru.practicum.lessonA.lesson2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.lessonA.lesson2.model.Argument;
import ru.practicum.lessonA.lesson2.model.ReversOrder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static ru.practicum.lessonA.lesson2.model.ReversOrder.NOT_REVERS;
import static ru.practicum.lessonA.lesson2.model.ReversOrder.REVERS;

//2. Отобразить в окне консоли аргументы командной строки в обратном по-
//рядке.
@Service
@RequiredArgsConstructor
public class ArgumentService {
    private final ArgumentRepository argumentRepository;

    public Argument ArgumentCreate(Argument argument) {
        return argumentRepository.argumentCurrent(argument);
    }

    public Collection<String> argumentReverseFindAll(ReversOrder order) {
        if (order.equals(NOT_REVERS)) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Argument argument : argumentRepository.argumentFindAll()) {
                arrayList.add(argument.getId() + " no_revers= " + argument);
            }
            return new ArrayList<>(arrayList);
        } else if (order.equals(REVERS)) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (Argument argument : argumentRepository.argumentFindAll()) {
                arrayList.add(argument.getId() + " revers= " + new StringBuffer().append(argument).reverse().toString());
            }
            return new ArrayList<>(arrayList);
        }
        return new ArrayList<>();
    }

    public Optional<Argument> postFindById(long posId) {
        return argumentRepository.argumentFindAll()
                .stream()
                .filter(id -> id.getId() == posId)
                .findFirst();
    }
}
