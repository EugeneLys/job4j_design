package ru.job4j.ood.lsp.parking;

public class Place {

    /*
    Класс описывает составной элемент парковки - парковочное место.
     */
    private String vehicleName;
    private int number;

    public Place(String carName, int number) {
        this.vehicleName = carName;
        this.number = number;
    }

    public String getCarName() {
        return vehicleName;
    }

    public void setCarName(String carName) {
        this.vehicleName = carName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
