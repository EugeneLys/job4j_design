package ru.job4j.ood.lsp.parking;

import java.io.IOException;
import java.util.ArrayList;
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
    public boolean park(Vehicle vehicle) throws IOException {
        boolean result = false;
        String name = vehicle.getName();
        Vehicle checkV = space.findByName(name);
        if (checkV != null && checkV.getName().equals(name)) {
            throw new IOException("The vehicle with such name is already parked.");
        }
        int size = vehicle.getSize();
        if (size == 1) {
            parkCar(size, name);
            result = true;
        } else {
            result = parkTruck(size, name);
            if (!result) {
                result = parkCar(size, name);
            }
        }
        if (!result) {
            throw new IOException("Can't park this vehicle - no free place.");
        }
        return result;
    }

    @Override
    public boolean remove(Vehicle vehicle) throws IOException {
        boolean result = false;
        for (Place place : space.getTrucks()) {
            if (vehicle.getName().equals(place.getVehicleName())) {
                place.setVehicleName(null);
                result = true;
            }
        }
        for (Place place : space.getCars()) {
            if (vehicle.getName().equals(place.getVehicleName())) {
                place.setVehicleName(null);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean findPlace(List<Place> list, Vehicle vehicle) {
        boolean result = true;
        if (list == space.getTrucks()) {
            result = vehicle.getSize() <= space.getTrucksCapacity();
        } else if (list == space.getCars()) {
            result = vehicle.getSize() <= space.getCarsCapacity();
        }
        return result;
    }

    private boolean parkCar(int size, String name) throws IOException {
        List<Place> temp = space.getCars();
        boolean result = false;
        int capacity = space.getCarsCapacity();
        if (size <= capacity) {
            while (size > 0) {
                temp.add(new Place(name, space.getInitialCarsCapacity() - space.getCarsCapacity() + 1));
                space.setCarsCapacity(capacity--);
                size--;
            }
            space.setCarsCapacity(capacity);
            space.setCars(temp);
            result = true;
        }
        return result;
    }

    private boolean parkTruck(int size, String name) throws IOException {
        List<Place> temp = space.getTrucks();
        boolean result = false;
        int capacity = space.getTrucksCapacity();
        if (size <= capacity) {
            while (size > 0) {
                temp.add(new Place(name, space.getInitialCarsCapacity() - space.getCarsCapacity() + 1));
                space.setTrucksCapacity(capacity--);
                size--;
            }
            space.setTrucks(temp);
            result = true;
        }
        return result;
    }

    public ParkingSpace getSpace() {
        return space;
    }

    public void setSpace(ParkingSpace space) {
        this.space = space;
    }
}
