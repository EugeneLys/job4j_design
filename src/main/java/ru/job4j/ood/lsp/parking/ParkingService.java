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
        boolean result;
        String name = vehicle.getName();
        Vehicle checkV = space.findByName(name);
        if (checkV != null && checkV.getName().equals(name)) {
            throw new IOException("The vehicle with such name is already parked.");
        }
        int size = vehicle.getSize();
        if (size == 1) {
            result = parkCar(size, name);
        } else {
            result = parkTruck(size, name);
            if (!result) {
                result = parkCar(size, name);
            }
        }
        if (!result) {
            throw new IOException("Can't park this vehicle - no free place.");
        }
        return true;
    }

    @Override
    public boolean remove(Vehicle vehicle) throws IOException {
        List<Place> temp;
        boolean result = false;
        int capC = space.getInitialCarsCapacity();
        int capT = space.getInitialTrucksCapacity();
        for (Place place : space.getCars()) {
            temp = new ArrayList<>(capC);
            if (!vehicle.getName().equals(place.getVehicleName())) {
                temp.add(place);
                }
                space.setCars(temp);
            space.setCarsCapacity(capC);
            }
        for (Place place : space.getTrucks()) {
            temp = new ArrayList<>(capT);
            if (!vehicle.getName().equals(place.getVehicleName())) {
                temp.add(place);
            }
            space.setTrucks(temp);
            space.setTrucksCapacity(capT);
        }
        return result;
    }

    private boolean parkCar(int size, String name) {
        List<Place> temp = space.getCars();
        boolean result = false;
        int capacity = space.getCarsCapacity();
        if (size <= capacity) {
            while (size > 0) {
                temp.add(new Place(name, space.getInitialCarsCapacity() - space.getCarsCapacity() + 1));
                capacity--;
                space.setCarsCapacity(capacity);
                size--;
            }
            space.setCars(temp);
            result = true;
        }
        return result;
    }

    private boolean parkTruck(int size, String name) {
        List<Place> temp = space.getTrucks();
        boolean result = false;
        int capacity = space.getTrucksCapacity();
        if (size <= capacity) {
            while (size > 0) {
                temp.add(new Place(name, space.getInitialTrucksCapacity() - space.getTrucksCapacity() + 1));
                capacity--;
                space.setTrucksCapacity(capacity);
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
