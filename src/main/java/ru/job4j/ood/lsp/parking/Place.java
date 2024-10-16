package ru.job4j.ood.lsp.parking;

import java.util.Objects;

public class Place {

    /*
    Класс описывает составной элемент парковки - парковочное место.
     */
    private String vehicleName;
    private int number;

    public Place(String vehicleName, int number) {
        this.vehicleName = vehicleName;
        this.number = number;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String carName) {
        this.vehicleName = carName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place place = (Place) o;
        return number == place.number && vehicleName.equals(place.vehicleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleName, number);
    }
}
