package ru.job4j.ood.lsp.parking;

import java.util.List;

public class ParkingService implements Parking {

    /*
    Класс описывает сервис по управлению парковкой (объектом класса ParkingSpace).
     */
    private ParkingSpace space;

    public ParkingService(ParkingSpace space) {
        this.space = space;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return false;
    }

    @Override
    public List<Integer> findPlace() {
        return null;
    }
}
