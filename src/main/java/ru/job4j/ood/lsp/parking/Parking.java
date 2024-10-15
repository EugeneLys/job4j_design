package ru.job4j.ood.lsp.parking;

import java.io.IOException;

public interface Parking {

    boolean park(Vehicle vehicle) throws IOException;

    boolean remove(Vehicle vehicle) throws IOException;
}
