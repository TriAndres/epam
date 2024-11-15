package ru.practicum.lessonA.model.password.file;

import ru.practicum.lessonA.model.password.model.Password;
import ru.practicum.lessonA.model.password.repository.PasswordRepositoryAble;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class PasswordFile extends PasswordRepositoryAble {
    private final String file;

    public PasswordFile(String file) {
        this.file = file;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            for (Password password : getByAll()) {
                if (password.getInterval() == null) password.setInterval(0);
                writer.write(String.join("/",
                        String.valueOf(password.getId()),
                        password.getLogin(),
                        password.getPassword(),
                        password.getName(),
                        password.getLocalDateTime(),
                        String.valueOf(password.getInterval())
                ));
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Password> getByAll() {
        return super.getByAll();
    }

    @Override
    public Password create(Password password) {
        Password p = super.create(password);
        save();
        return p;
    }

    @Override
    public void clear() {
        save();
        super.clear();
    }

    @Override
    public void deleteId(long id) {
        save();
        super.deleteId(id);
    }

    @Override
    public Password getById(long id) {
        Password p = super.getById(id);
        save();
        return p;
    }

    @Override
    public boolean containsKey(long id) {
        return super.containsKey(id);
    }

    public static PasswordFile loadFromFile(String file) {
        PasswordFile service = new PasswordFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                service.create(new Password(
                        Long.parseLong(row[0]),
                        row[1],
                        row[2],
                        row[3],
                        row[4],
                        Integer.parseInt(row[5])
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return service;
    }
}
