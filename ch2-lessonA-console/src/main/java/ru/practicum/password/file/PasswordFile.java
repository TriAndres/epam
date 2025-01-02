package ru.practicum.password.file;

import ru.practicum.password.model.Password;
import ru.practicum.password.repository.PasswordRepositoryImpl;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class PasswordFile extends PasswordRepositoryImpl {
    private final String file;

    public PasswordFile(String file) {
        this.file = file;
    }

    public void saveF() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Password password : findAll()) {
                if (password.getInterval() == null) password.setInterval(0);
                writer.write(
                        String.format("%d/%s/%s/%s/%s/%s/%s\n"
                                , password.getId()
                                , password.getLogin()
                                , password.getPassword()
                                , password.getRegistration()
                                , password.getName()
                                , password.getLocalDateTime()
                                , String.valueOf(password.getInterval())
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Password> findAll() {
        return super.findAll();
    }

    @Override
    public Password save(Password password) {
        Password p = super.save(password);
        saveF();
        return p;
    }

    @Override
    public boolean containsKey(long id) {
        return super.containsKey(id);
    }

    @Override
    public Password findById(long id) {
        Password p = super.findById(id);
        saveF();
        return p;
    }

    @Override
    public void deleteId(long id) {
        super.deleteId(id);
        saveF();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        saveF();
    }

    public static PasswordFile loadFromFile(String file) {
        PasswordFile passwordFile = new PasswordFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");

                passwordFile.save(new Password(
                        Long.parseLong(row[0]),
                        row[1],
                        row[2],
                        Boolean.valueOf(row[3]),
                        row[4],
                        row[5],
                        Integer.parseInt(row[6])
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return passwordFile;
    }
}
