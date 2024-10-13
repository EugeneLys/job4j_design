package ru.job4j.ood.lsp.parking;

import java.io.IOException;
import java.util.Objects;

public class Vehicle {
    /*
    Класс описывает отдельный автомобиль
     */
    String name;
    int size;

    public Vehicle(String name, int size) throws IOException {
        if (name == null) {
            throw new IOException("Name could not be null");
        }
        if (size < 1) {
            throw new IOException("Size should not be less than 1");
        }
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IOException {
        if (name == null) {
            throw new IOException("Name could not be null");
        }
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) throws IOException {
        if (size < 1) {
            throw new IOException("Size should not be less than 1");
        }
        this.size = size;
    }
}
