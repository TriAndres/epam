package ru.practicum.password.file;

import ru.practicum.password.model.Password;
import ru.practicum.password.repository.PasswordRepositoryImpl;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PasswordFile extends PasswordRepositoryImpl {
    private final String file;

    public PasswordFile(String file) {
        this.file = file;
    }

    public void saveF() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Password password : findAll()) {
                //String time = "";
//                if (!(password.getLocalDateTime() == null)) {
//                   time = String.valueOf(password.getLocalDateTime());
////                    LocalDateTime localDateTime = password.getLocalDateTime();
////                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
////                    time = localDateTime.format(formatter);
//                } else {
//                    LocalDateTime localDateTime = LocalDateTime.now();//password.getLocalDateTime();
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//                    time = localDateTime.format(formatter);
//                }

//
//                String interval;
//                if (password.getInterval() != null) {
//                    String interval = String.valueOf(password.getInterval());
//                } else {
//                    interval = null;
//                }

                writer.write(
                        String.format("%d/%s/%s/%s/%s\n"
                                , password.getId()
                                , password.getLogin()
                                , password.getPassword()
                                , password.getRegistration()
                                , password.getName()
                                //, time
                                //, password.getInterval()
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

                //String str = "2014-04-08 12:30";
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//                LocalDateTime dateTime = LocalDateTime.parse(row[5],formatter);
                passwordFile.save(new Password(
                        Long.parseLong(row[0]),
                        row[1],
                        row[2],
                        Boolean.valueOf(row[3]),
                        row[4]
                        //dateTime,//LocalDateTime.parse(row[5]),
                        //Integer.parseInt(row[6])
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return passwordFile;
    }
}
