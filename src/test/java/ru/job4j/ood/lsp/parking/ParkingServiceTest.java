package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {

    /*
    ����� �������� ���� ����� ������ � ��� ������ ��������� � ��������������� �������,
    (��� �������� - � ������ "cars", ���� �������� - � ������ "trucks")
    � ��������� �� ���� �� ��������������� ����������� ������.
     */
    @Test
    void whenCorrectParkTwoCarsAndOneTruck() throws IOException {
        ParkingSpace space = new ParkingSpace(2, 2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        Vehicle car2 = new Vehicle("car2", 1);
        Vehicle truck1 = new Vehicle("truck1", 2);
        service.park(car1);
        service.park(truck1);
        service.park(car2);
        List<Place> expectedCars = List.of(new Place("car1", 1),
                new Place("car2", 2));
        List<Place> expectedTrucks = List.of(new Place("truck1", 1),
                new Place("truck1", 2));
        assertEquals(space.getCars(), expectedCars);
        assertEquals(space.getTrucks(), expectedTrucks);
    }

    /*
    ����� �������� � �������� ����� �������������� �����,
    �� ����� ������ �� ������� �� ��������������� ����������� ������.
    ��� ���� ������ � ������, �� ��������� ���������� ("car2"), ��������.
     */
    @Test
    void whenDeleteCars() throws IOException {
        ParkingSpace space = new ParkingSpace(2, 2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        Vehicle car2 = new Vehicle("car2", 1);
        Vehicle truck1 = new Vehicle("truck1", 2);
        service.park(car1);
        service.park(car2);
        service.park(truck1);
        service.remove(space.findByName("car1"));
        service.remove(space.findByName("truck1"));
        assertNull(space.findByName("car1"));
        assertNull(space.findByName("truck1"));
        Vehicle expected = new Vehicle("car2", 1);
        assertEquals(expected, space.findByName("car2"));
    }

    /*
    ����� �������� � �������� ����� �������������� �����,
    �� "��" ����� ����� �������� ����� ������.
     */
    @Test
    void whenDeleteAndAddCars() throws IOException {
        ParkingSpace space = new ParkingSpace(1,  0);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        service.park(car1);
        assertEquals("car1", space.getCars().get(0).getVehicleName());
        service.remove(space.findByName("car1"));
        Vehicle car2 = new Vehicle("car2", 1);
        service.park(car2);
        assertEquals("car2", space.getCars().get(0).getVehicleName());
    }

    /*
    ����� ��� ����� �� �������� ��� ���������� ������,
    ��������� �������� ������ ���� ������� �� ������ �������� ��� �������� �����������.
     */
    @Test
    void whenNoFreePlaceThenParkTruckToCars() throws IOException {
        ParkingSpace space = new ParkingSpace(2, 2);
        ParkingService service = new ParkingService(space);
        Vehicle truck1 = new Vehicle("truck1", 2);
        Vehicle truck2 = new Vehicle("truck2", 2);
        service.park(truck1);
        assertEquals("truck1", space.getTrucks().get(0).getVehicleName());
        assertEquals("truck1", space.getTrucks().get(1).getVehicleName());
        service.park(truck2);
        assertEquals("truck2", space.getCars().get(0).getVehicleName());
        assertEquals("truck2", space.getCars().get(1).getVehicleName());
    }

    /*
    ����� ��� ����� �� �������� ��� �������� ����������� ������,
    ������ ���� ��������� ���������� (�� �������� �� ���������).
     */
    @Test
    void whenNoFreePlaceForCarThenException() throws IOException {
        ParkingSpace space = new ParkingSpace(2, 2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        Vehicle car2 = new Vehicle("car2", 1);
        Vehicle car3 = new Vehicle("car3", 1);
        service.park(car1);
        service.park(car2);
        assertThatThrownBy(() -> service.park(car3))
                .isInstanceOf(Exception.class).hasMessageContaining("Can't park this vehicle - no free place.");
    }

    /*
    ����� ������������ ����� �� �������� ��� ����������, �������� ��������� �� ������ ��� �������� �����������.
     */
    @Test
    void whenNotEnoughPlaceForTruckThenParkToCars() throws IOException {
        ParkingSpace space = new ParkingSpace(3, 2);
        ParkingService service = new ParkingService(space);
        Vehicle truck1 = new Vehicle("truck1", 3);
        service.park(truck1);
        assertEquals("truck1", space.getCars().get(0).getVehicleName());
        assertEquals("truck1", space.getCars().get(1).getVehicleName());
        assertEquals("truck1", space.getCars().get(2).getVehicleName());
        assertEquals(0, space.getTrucks().size());
    }

    /*
    ����� ������������ ����� �� �������� ��� �������� �����������,
    �������� �� ����� �������������� ( -> Exception).
     */
    @Test
    void whenNoCarsPlaceForTruckThenException() throws IOException {
        ParkingSpace space = new ParkingSpace(2, 2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car1", 1);
        Vehicle truck1 = new Vehicle("truck1", 2);
        Vehicle truck2 = new Vehicle("truck2", 2);
        service.park(car1);
        service.park(truck1);
        assertThatThrownBy(() -> service.park(truck2))
                .isInstanceOf(Exception.class).hasMessageContaining("Can't park this vehicle - no free place.");
    }

    /*
    ����� ��������� ������ � ����� �� ������, ��� � � ����� ��������������, �� ������������� ����������.
     */
    @Test
    void whenVehicleNameAlreadyExist() throws IOException {
        ParkingSpace space = new ParkingSpace(3, 2);
        ParkingService service = new ParkingService(space);
        Vehicle car1 = new Vehicle("car", 1);
        Vehicle car2 = new Vehicle("car", 1);
        service.park(car1);
        assertThatThrownBy(() -> service.park(car2))
                .isInstanceOf(Exception.class).hasMessageContaining("The vehicle with such name is already parked.");
    }
}