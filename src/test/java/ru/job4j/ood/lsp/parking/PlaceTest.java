package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    /*
    Проверка методов get и set класса Place.
     */
    @Test
    void whenSetAndGet() {
        Place place = new Place("car", 1);
        String expected = "car";
        int expected2 = 1;
        assertEquals(expected, place.getVehicleName());
        assertEquals(expected2, place.getNumber());
    }
}