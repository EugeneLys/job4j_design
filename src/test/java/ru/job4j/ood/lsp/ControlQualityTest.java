package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControlQualityTest {

    @Test
    void whenDistributeAllExistingFoodInStore() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        Food close = new Food("bread", LocalDate.of(2024, 10, 11),
                LocalDate.of(2024, 9, 1), 100, 0);
        Food overdue = new Food("milk", LocalDate.of(2024, 10, 8),
                LocalDate.of(2024, 9, 1), 100, 0);
        trash.add(close);
        trash.add(overdue);
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distributeAll();
        assertTrue(shop.list.contains(shop.findByName("bread")));
        assertEquals(20, close.getDiscount());
        assertTrue(trash.list.contains(trash.findByName("milk")));
    }

    @Test
    void whenAddListOfFood() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        List<Food> lot = new ArrayList<>();
        Food close = new Food("bread", LocalDate.of(2024, 10, 11),
                LocalDate.of(2024, 9, 1), 100, 0);
        Food overdue = new Food("milk", LocalDate.of(2024, 10, 8),
                LocalDate.of(2024, 9, 1), 100, 0);
        lot.add(close);
        lot.add(overdue);
        int expectedPrice = 80;
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.addList(lot);
        assertTrue(shop.list.contains(shop.findByName("bread")));
        assertEquals(expectedPrice, shop.findByName("bread").getPrice());
        assertTrue(trash.list.contains(trash.findByName("milk")));
    }

    @Test
    void whenAddNewFood() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        Food close = new Food("bread", LocalDate.of(2024, 10, 11),
                LocalDate.of(2024, 9, 1), 100, 0);
        Food overdue = new Food("milk", LocalDate.of(2024, 10, 8),
                LocalDate.of(2024, 9, 1), 100, 0);
        int expectedPrice = 80;
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.add(close);
        controlQuality.add(overdue);
        assertTrue(shop.list.contains(shop.findByName("bread")));
        assertEquals(expectedPrice, close.getPrice());
        assertTrue(trash.list.contains(trash.findByName("milk")));
    }
}