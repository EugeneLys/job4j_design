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
        String check = vehicle.getName();
        Vehicle checkV = space.findByName(check);
        if (checkV != null && checkV.getName().equals(vehicle.getName())) {
            throw new IOException("The vehicle with such name is already parked.");
        }
        int size = vehicle.getSize();
        List<Place> temp;
        int allow;
        if (size > 1) {
            temp = space.getTrucks();
            allow = space.getTrucksCapacity();
            if (allow >= size) {
                while (size > 0) {
                    temp.add(new Place(check, space.getInitialTrucksCapacity() - space.getTrucksCapacity() + 1));
                    space.setTrucksCapacity(space.getTrucksCapacity() - 1);
                    size--;
                }
                space.setTrucks(temp);
                result = true;
            }
        } else {
            temp = space.getCars();
            allow = space.getCarsCapacity();
            if (allow > 0) {
                temp.add(new Place(check, space.getInitialCarsCapacity() - space.getCarsCapacity() + 1));
                space.setCarsCapacity(space.getCarsCapacity() - 1);
                space.setCars(temp);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return false;
    }

    @Override
    public List<Integer> findPlace(List<Place> list) {
        List<Integer> result = new ArrayList<>();
        for (Place p : list) {
            if (p.getVehicleName() == null) {
                result.add(p.getNumber());
            }
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
