package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {

    @BeforeEach
    void setUp() {
    }

    /*
    После парковки трех машин они появились в соответствующих списках,
    (легковые - в списке "cars", грузовая - в списке "trucks")
    с указанием их имен на соответствующих парковочных местах.
     */
    @Test
    void whenParkTwoCarsAndOneTruck() {
        ParkingSpace space = new ParkingSpace(2,2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        Vehicle car2 = new Vehicle("car2", 1);
        Vehicle truck1 = new Vehicle("truck1", 2);
        service.park(car1);
        service.park(car2);
        service.park(truck1);
        List<Place> expectedCars = List.of(new Place("car1", 1),
                new Place("car2", 2));
        List<Place> expectedTrucks = List.of(new Place("truck1", 1),
                new Place("truck1", 2));
        assertEquals(space.getCars(), expectedCars);
        assertEquals(space.getTrucks(), expectedTrucks);
    }

    /*
    После удаления с парковки ранее припаркованных машин,
    их имена больше не указаны на соответствующих парковочных местах.
    При этом запись о другом, не удаляемом автомобиле ("car2"), остается.
     */
    @Test
    void whenDeleteCars() {
        ParkingSpace space = new ParkingSpace(2,2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        Vehicle car2 = new Vehicle("car2", 1);
        Vehicle truck1 = new Vehicle("truck1", 2);
        service.park(car1);
        service.park(car2);
        service.park(truck1);
        assertEquals("car1", space.getCars().get(0).getCarName());
        assertEquals("car2", space.getCars().get(1).getCarName());
        assertEquals("truck1", space.getTrucks().get(0).getCarName());
        assertEquals("truck1", space.getTrucks().get(1).getCarName());
        service.remove(space.findByName("car1"));
        service.remove(space.findByName("truck1"));
        assertNull(space.getCars().get(0).getCarName());
        assertNull(space.getTrucks().get(0).getCarName());
        assertNull(space.getTrucks().get(1).getCarName());
        assertEquals("car2", space.getCars().get(1).getCarName());
    }

    /*
    Когда все места на парковке для грузовиков заняты,
    следющий грузовик будет записан на парковку для легковых автомобилей.
     */
    @Test
    void whenParkSecondTruckToCarsPlace() {
        ParkingSpace space = new ParkingSpace(2,2);
        ParkingService service = new ParkingService(space);
        Vehicle truck1 = new Vehicle("truck1", 2);
        Vehicle truck2 = new Vehicle("truck2", 2);
        service.park(truck1);
        assertEquals("truck1", space.getTrucks().get(0).getCarName());
        assertEquals("truck1", space.getTrucks().get(1).getCarName());
        service.park(truck2);
        assertEquals("truck2", space.getCars().get(0).getCarName());
        assertEquals("truck2", space.getCars().get(1).getCarName());
    }

    /*
    Когда все места на парковке для грузовиков заняты,
    следющий грузовик будет записан на парковку для легковых автомобилей.
     */
    @Test
    void whenNoFreeParkingThenException() {
        ParkingSpace space = new ParkingSpace(2,2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        Vehicle car2 = new Vehicle("car2", 1);
        Vehicle truck1 = new Vehicle("truck1", 2);
        service.park(car1);
        service.park(car2);
        service.park(truck1);
        Vehicle car3 = new Vehicle("car3", 1);
        assertThatThrownBy(() -> service.park(car3))
                .isInstanceOf(Exception.class);
    }
}