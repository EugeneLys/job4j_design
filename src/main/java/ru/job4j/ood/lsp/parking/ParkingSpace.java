package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {

    /*
    Парковка состоит из отдельных списков мест для легковых и грузовых машин
     */
    private List<Place> cars;
    private List<Place> trucks;

    public ParkingSpace(int carCapacity, int truckCapacity) {
        this.cars = new ArrayList<>(carCapacity);
        this.trucks = new ArrayList<>(truckCapacity);
    }

    public List<Place> getCars() {
        return cars;
    }

    public void setCars(List<Place> cars) {
        this.cars = cars;
    }

    public List<Place> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Place> trucks) {
        this.trucks = trucks;
    }

    public Vehicle findByName(String name) {
        return null;
    }
}
