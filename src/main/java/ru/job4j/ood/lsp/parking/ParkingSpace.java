package ru.job4j.ood.lsp.parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {

    /*
    Парковка состоит из отдельных списков мест для легковых и грузовых машин
    */
    private int initialCarsCapacity;
    private int initialTrucksCapacity;
    private int carsCapacity;
    private int trucksCapacity;
    private List<Place> cars;
    private List<Place> trucks;

    public ParkingSpace(int initialCarsCapacity, int initialTrucksCapacity) {
        this.initialCarsCapacity = initialCarsCapacity;
        this.initialTrucksCapacity = initialTrucksCapacity;
        this.cars = new ArrayList<>(initialCarsCapacity);
        this.trucks = new ArrayList<>(initialTrucksCapacity);
        setCarsCapacity(initialCarsCapacity);
        setTrucksCapacity(initialTrucksCapacity);
    }

    public int getInitialCarsCapacity() {
        return initialCarsCapacity;
    }

    public int getInitialTrucksCapacity() {
        return initialTrucksCapacity;
    }

    public void setCarsCapacity(int carsCapacity) {
        this.carsCapacity = carsCapacity;
    }

    public void setTrucksCapacity(int truckCapacity) {
        this.trucksCapacity = truckCapacity;
    }

    public int getCarsCapacity() {
        return carsCapacity;
    }

    public int getTrucksCapacity() {
        return trucksCapacity;
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
        Vehicle result = null;
        for (Place car : cars) {
            String check = car.getVehicleName();
            if (name.equals(check)) {
                return new Vehicle(check, 1);
            }
        }
        for (Place truck : trucks) {
            String check = truck.getVehicleName();
            if (name.equals(check)) {
                size++;
                result = new Vehicle(check, size);
            }
        }
        return result;
    }
}
