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

    /*
    Метод исследует автомобиль, по результатам определяет порядок его парковки
    и вызывает приватный метод findPlace с нужными аргументами.
     */
    @Override
    public boolean park(Vehicle vehicle) throws IOException {
        boolean result;
        String name = vehicle.getName();
        int size = vehicle.getSize();
        Vehicle existing = space.findByName(name);
        if (existing != null && existing.getName().equals(name)) {
            throw new IOException("The vehicle with such name is already parked.");
        }
        if (size == 1) {
            result = findPlace(size, name, false);
        } else {
            result = findPlace(size, name, true) || findPlace(size, name, false);
        }
        if (!result) {
            throw new IOException("Can't park this vehicle - no free place.");
        }
        return true;
    }

    @Override
    public boolean remove(Vehicle vehicle) throws IOException {
        boolean result = false;
        List<Place> temp;
        boolean truck = vehicle.getSize() > 1;
        List<Place> list = truck ? space.getTrucks() : space.getCars();
        int cap = vehicle.getSize() == 1 ? space.getInitialCarsCapacity() : space.getInitialTrucksCapacity();
        for (Place place : list) {
            temp = new ArrayList<>(cap);
            if (!vehicle.getName().equals(place.getVehicleName())) {
                temp.add(place);
                result = true;
                }
            if (truck) {
                space.setTrucks(temp);
                space.setCurrentTrucksCapacity(cap);
            } else {
                space.setCars(temp);
                space.setCurrentCarsCapacity(cap);
            }
        }
        return result;
    }

    /*
    Метод определяет механизм поиска мест на парковке и размещения на них (нем) автомобиля.
     */
    private boolean findPlace(int size, String name, boolean truck) {
        List<Place> temp = truck ? space.getTrucks() : space.getCars();
        int capacity = truck ? space.getCurrentTrucksCapacity() : space.getCurrentCarsCapacity();
        int init = truck ? space.getInitialTrucksCapacity() : space.getInitialCarsCapacity();
        if (size <= capacity) {
            while (size > 0) {
                temp.add(new Place(name, init - capacity + 1));
                capacity--;
                size--;
                if (truck) {
                    space.setCurrentTrucksCapacity(capacity);
                    space.setTrucks(temp);
                } else {
                    space.setCurrentCarsCapacity(capacity);
                    space.setCars(temp);
                }
            }
            return true;
        }
        return false;
    }

    public ParkingSpace getSpace() {
        return space;
    }

    public void setSpace(ParkingSpace space) {
        this.space = space;
    }
}
