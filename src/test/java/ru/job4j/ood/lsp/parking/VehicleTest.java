package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    /*
    �������� get � set ������ Vehicle;
     */
    @Test
    void whenCorrectSetAndGet() throws IOException {
        Vehicle car = new Vehicle("car", 1);
        car.setName("newName");
        car.setSize(2);
        String expected = "newName";
        int expected2 = 2;
        assertEquals(expected, car.getName());
        assertEquals(expected2, car.getSize());
    }


    /*
    �������� ���������� ��� ��������� ������������ ������� ������.
     */
    @Test
    void whenWrongSizeVehicleInitialization() {
        assertThatThrownBy(() -> new Vehicle("car", 0))
                .isInstanceOf(Exception.class).hasMessageContaining("Size should not be less than 1");
    }

    /*
    �������� ���������� ��� ����� ������� ������ �� �����������.
     */
    @Test
    void whenWrongSizeVehicleSet() throws IOException {
        Vehicle car = new Vehicle("car", 1);
        assertThatThrownBy(() -> car.setSize(0))
                .isInstanceOf(Exception.class).hasMessageContaining("Size should not be less than 1");
    }

    /*
    �������� ���������� ��� ���������� �����.
     */
    @Test
    void whenInitialiseNullNameThenException() {
        assertThatThrownBy(() -> new Vehicle(null, 1))
                .isInstanceOf(Exception.class).hasMessageContaining("Name could not be null");
    }

    /*
    �������� ���������� ��� ������������ ������������� �����.
     */
    @Test
    void whenSetNullNameThenException() throws IOException {
        Vehicle car = new Vehicle("car", 1);
        assertThatThrownBy(() -> car.setName(null))
                .isInstanceOf(Exception.class).hasMessageContaining("Name could not be null");
    }
}