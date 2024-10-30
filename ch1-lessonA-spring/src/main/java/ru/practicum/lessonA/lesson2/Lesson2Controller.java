package ru.practicum.lessonA.lesson2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.lessonA.lesson2.model.Lesson2;
import ru.practicum.lessonA.lesson2.model.ReversOrder;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/lesson2")
@RestController
@RequiredArgsConstructor
public class Lesson2Controller {
    private final Lesson2Service lesson2Service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson2 lesson2Create(@RequestBody Lesson2 lesson2) {
        return lesson2Service.lesson2Create(lesson2);
    }

    @GetMapping
    private Collection<String> lesson2ReverseFindAll(
            @RequestParam(defaultValue = "notreverse") String reverse) {
        return lesson2Service.lesson2ReverseFindAll(ReversOrder.from(reverse));
    }

    @GetMapping("/{lesson2Id}")
    public Optional<Lesson2> lesson2FindById(@PathVariable long lesson2Id) {
        return lesson2Service.lesson2FindById(lesson2Id);
    }

}