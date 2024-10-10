package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControlQualityTest {

    /*
    Тест проверяет корректность выполнения принудительной сортировки хранилища
    (метод distributeAll() класса ControlQuality).
    Два продукта, по свойствам соответствующие хранилищам
    shop и trash, изначально добавляются в warehouse и должны распределиться
    по "правильным" хранилищам (с добавлением скидки).
     */
    @Test
    void whenDistributeAllExistingFoodInStore() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        LocalDate oneDayToOverdue = LocalDate.now().plusDays(1);
        Food close = new Food("bread", oneDayToOverdue,
                LocalDate.of(2024, 9, 1), 100, 0);
        Food overdue = new Food("milk", LocalDate.of(2024, 10, 8),
                LocalDate.of(2024, 9, 1), 100, 0);
        warehouse.add(close);
        warehouse.add(overdue);
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.distributeAll();
        assertTrue(shop.list.contains(shop.findByName("bread")));
        assertEquals(20, close.getDiscount());
        assertTrue(trash.list.contains(trash.findByName("milk")));
    }

    /*
    Тест проверяет корректность добавления новых продуктов в хранилища сразу списком.
    (метод addList() класса ControlQuality)
     */
    @Test
    void whenAddListOfFood() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        LocalDate oneDayToOverdue = LocalDate.now().plusDays(1);
        List<Food> lot = new ArrayList<>();
        Food close = new Food("bread", oneDayToOverdue,
                LocalDate.of(2024, 9, 1), 100, 0);
        Food overdue = new Food("milk", LocalDate.of(2024, 10, 8),
                LocalDate.of(2024, 9, 1), 100, 0);
        lot.add(close);
        lot.add(overdue);
        double expectedPrice = 80.0;
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.addList(lot);
        assertTrue(shop.list.contains(shop.findByName("bread")));
        assertEquals(expectedPrice, shop.findByName("bread").getPrice());
        assertTrue(trash.list.contains(trash.findByName("milk")));
    }

    /*
    Тест добавления нового продукта в хранилища.
    (метод add() класса ControlQuality)
     */
    @Test
    void whenAddNewFood() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        List<Store> storage = List.of(warehouse, shop, trash);
        LocalDate oneDayToOverdue = LocalDate.now().plusDays(1);
        Food close = new Food("bread", oneDayToOverdue,
                LocalDate.of(2024, 9, 1), 100, 0);
        Food overdue = new Food("milk", LocalDate.of(2024, 10, 8),
                LocalDate.of(2024, 9, 1), 100, 0);
        double expectedPrice = 80.0;
        ControlQuality controlQuality = new ControlQuality(storage);
        controlQuality.add(close);
        controlQuality.add(overdue);
        assertTrue(shop.list.contains(shop.findByName("bread")));
        assertEquals(expectedPrice, close.getPrice());
        assertTrue(trash.list.contains(trash.findByName("milk")));
    }
}