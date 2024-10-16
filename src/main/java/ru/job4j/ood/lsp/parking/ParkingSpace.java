package ru.job4j.ood.lsp.parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {

    /*
    Парковка состоит из отдельных списков мест для легковых и грузовых машин
    Приватные переменные с ключевым словом "Capacity" определяют
    начальное и текущее числа доступных мест на парковке (т.е. в cars и trucks).
    */
    private final int initialCarsCapacity;
    private final int initialTrucksCapacity;
    private int currentCarsCapacity;
    private int currentTrucksCapacity;
    private List<Place> cars;
    private List<Place> trucks;

    public ParkingSpace(int initialCarsCapacity, int initialTrucksCapacity) {
        this.initialCarsCapacity = initialCarsCapacity;
        this.initialTrucksCapacity = initialTrucksCapacity;
        this.cars = new ArrayList<>(initialCarsCapacity);
        this.trucks = new ArrayList<>(initialTrucksCapacity);
        setCurrentCarsCapacity(initialCarsCapacity);
        setCurrentTrucksCapacity(initialTrucksCapacity);
    }

    public int getInitialCarsCapacity() {
        return initialCarsCapacity;
    }

    public int getInitialTrucksCapacity() {
        return initialTrucksCapacity;
    }

    public void setCurrentCarsCapacity(int currentCarsCapacity) {
        this.currentCarsCapacity = currentCarsCapacity;
    }

    public void setCurrentTrucksCapacity(int truckCapacity) {
        this.currentTrucksCapacity = truckCapacity;
    }

    public int getCurrentCarsCapacity() {
        return currentCarsCapacity;
    }

    public int getCurrentTrucksCapacity() {
        return currentTrucksCapacity;
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

    public Vehicle findByName(String name) throws IOException {
        int size = 0;
        String next;
        Vehicle result = null;
        for (Place car : cars) {
            next = car.getVehicleName();
            if (name.equals(next)) {
                return new Vehicle(next, 1);
            }
        }
        for (Place truck : trucks) {
            next = truck.getVehicleName();
            if (name.equals(next)) {
                size++;
                result = new Vehicle(next, size);
            }
        }
        return result;
    }
}
