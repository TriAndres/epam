package ru.practicum.lessonA.model.password.service;

import ru.practicum.lessonA.model.password.file.PasswordFile;

import static ru.practicum.lessonA.model.password.file.PasswordFile.loadFromFile;

public class PasswordLesson6Service {
    private final PasswordFile passwordFile;

    public PasswordLesson6Service(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public static void main(String[] args) {
        String file = "ch1-lessonA-console\\src\\main\\java\\ru\\practicum\\lessonA\\model\\password\\file\\PasswordFile.txt";
        PasswordFile passwordFile = loadFromFile(file);
        PasswordLesson6Service pls = new PasswordLesson6Service(passwordFile);

        pls.lesson6();
    }

    /*
     6. Вывести фамилию разработчика, дату и время получения задания, а также
    дату и время сдачи задания.
     */
    public void lesson6() {

    }
}