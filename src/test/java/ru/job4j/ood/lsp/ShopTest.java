package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShopTest {

    /*
    ѕроверка корректности работы метода replace() класса Shop
    и других, унаследованных от AbstractStore, методов.
     */
    @Test
    void whenAddNewFood() {
        Shop shop = new Shop(new ArrayList<>());
        LocalDate oneDayLeft = LocalDate.now().plusDays(1);
        Food f1 = new Food("bread", oneDayLeft,
                LocalDate.of(2024, 9, 1), 100, 0);
        shop.add(f1);
        List<Food> check = new ArrayList<>();
        List<Food> temp = List.of(f1);
        assertEquals(f1, shop.findByName("bread"));
        assertEquals(temp, shop.findAll());
        assertTrue(shop.replace(f1, check));
        assertTrue(check.contains(f1));
        shop.delete("bread");
        assertEquals(0, shop.list.size());
    }
}