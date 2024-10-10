package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TrashTest {

    /*
    Проверка корректности работы унаследованных от AbstractStore методов класса Shop.
    Метод replace() возвращает false и ничего не делает (из Trash продукты некуда перемещать),
    в лист check продукт не перемещается.
     */
    @Test
    void whenAddNewFood() {
        Trash trash = new Trash(new ArrayList<>());
        LocalDate late = LocalDate.now().minusDays(1);
        Food f1 = new Food("bread", late,
                LocalDate.of(2024, 9, 1), 100, 0);
        trash.add(f1);
        List<Food> check = new ArrayList<>();
        List<Food> temp = List.of(f1);
        assertEquals(f1, trash.findByName("bread"));
        assertEquals(temp, trash.findAll());
        assertFalse(trash.replace(f1, check));
        assertFalse(check.contains(f1));
        trash.delete("bread");
        assertEquals(0, trash.list.size());
    }
}