package ru.job4j.ood.lsp.parking;

public class Vehicle {
    /*
    Класс описывает отдельный автомобиль
     */
    String name;
    int size;

    public Vehicle(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
