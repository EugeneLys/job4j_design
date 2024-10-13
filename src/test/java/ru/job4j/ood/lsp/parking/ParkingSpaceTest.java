package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceTest {

    /*
    Проверка работы get и set: создаются и добавляются в поля cars и trucks списки объектов Place,
    содержащие сведения об именах машин.
    Методы типа get должны вернуть такие же списки.
     */
    @Test
    void whenCorrectSetAndGet() {
        ParkingSpace space = new ParkingSpace(3, 2);
        space.setCars(List.of(new Place("car1", 1),
                new Place("car2", 2), new Place("car3", 3)));
        space.setTrucks(List.of(new Place("truck1", 1),
                new Place("truck1", 2)));
        List<Place> expected = List.of(new Place("car1", 1),
                new Place("car2", 2), new Place("car3", 3));
        List<Place> expected2 = List.of(new Place("truck1", 1),
                new Place("truck1", 2));
        assertEquals(expected, space.getCars());
        assertEquals(expected2, space.getTrucks());
    }

    /*
    Проверка поиска машины по имени.
     */
    @Test
    void whenFindByName() {
        ParkingSpace space = new ParkingSpace(3, 2);
        Vehicle car = new Vehicle("car1", 1);
        space.setCars(List.of(new Place(car.getName(), 1),
                new Place(null, 2), new Place(null, 3)));
        Vehicle expected = new Vehicle("car1", 1);
        assertEquals(expected, space.findByName("car1"));
    }
}