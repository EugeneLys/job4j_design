package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarehouseTest {

    /*
    ѕроверка корректности работы метода replace() класса Warehouse
    и других, унаследованных от AbstractStore, методов.
     */
    @Test
    void whenAddNewFood() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        LocalDate bestBefore = LocalDate.now().plusDays(10);
        Food f1 = new Food("bread", bestBefore,
                LocalDate.of(2024, 9, 1), 100, 0);
        warehouse.add(f1);
        List<Food> check = new ArrayList<>();
        List<Food> temp = List.of(f1);
        assertEquals(f1, warehouse.findByName("bread"));
        assertEquals(temp, warehouse.findAll());
        assertTrue(warehouse.replace(f1, check));
        assertTrue(check.contains(f1));
        warehouse.delete("bread");
        assertEquals(0, warehouse.list.size());
    }
}