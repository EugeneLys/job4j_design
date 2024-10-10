package ru.job4j.ood.lsp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControlQualityTest {

    @Test
    void whenCorrectAllAtATime() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        //List<Food> list = new ArrayList<>();
        Food close = new Food("bread", LocalDate.of(2024, 10, 10),
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
    void whenCorrectByOne() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        Food close = new Food("bread", LocalDate.of(2024, 10, 10),
                LocalDate.of(2024, 9, 1), 100, 0);
        Food overdue = new Food("milk", LocalDate.of(2024, 10, 8),
                LocalDate.of(2024, 9, 1), 100, 0);
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distributeOne(close);
        controlQuality.distributeOne(overdue);
        assertTrue(shop.list.contains(shop.findByName("bread")));
        assertEquals(20, close.getDiscount());
        assertTrue(trash.list.contains(trash.findByName("milk")));
    }
}