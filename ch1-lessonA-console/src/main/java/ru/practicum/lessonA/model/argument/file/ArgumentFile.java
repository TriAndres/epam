package ru.practicum.lessonA.model.argument.file;

import ru.practicum.lessonA.model.argument.model.Argument;
import ru.practicum.lessonA.model.argument.repo.ArgumentRepositoryAble;

import java.io.*;
import java.util.Collection;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ArgumentFile extends ArgumentRepositoryAble {
    private final String file;

    public ArgumentFile(String file) {
        this.file = file;
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, UTF_8))) {
            for (Argument argument : getArgumentAll()) {
                writer.write(String.valueOf(argument.getId()) + "/" + argument.getArgument() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Argument> getArgumentAll() {
        return super.getArgumentAll();
    }


    @Override
    public void create(Argument argument) {
        super.create(argument);
        save();
    }

    @Override
    public boolean containsKey(long id) {
        return super.containsKey(id);
    }

    @Override
    public Argument findById(long id) {
        Argument argument = super.findById(id);
        save();
        return argument;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        save();
    }

    public static ArgumentFile loadFromFile(String file) {
        ArgumentFile argumentFile = new ArgumentFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file, UTF_8))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                argumentFile.create(new Argument(Long.valueOf(row[0]), row[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return argumentFile;
    }
}
