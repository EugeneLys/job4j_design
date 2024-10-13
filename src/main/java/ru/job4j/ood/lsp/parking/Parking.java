package ru.job4j.ood.lsp.parking;

import java.io.IOException;
import java.util.List;

public interface Parking {

    boolean park(Vehicle vehicle) throws IOException;

    boolean remove(Vehicle vehicle);

    List<Integer> findPlace(List<Place> list);
}
