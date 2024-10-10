package ru.job4j.ood.lsp;

import java.util.List;

public interface Store {

    Food add(Food food);

    boolean replace(Food food, List<Food> list);

    boolean delete(String name);

    List<Food> findAll();

    Food findByName(String name);
}
