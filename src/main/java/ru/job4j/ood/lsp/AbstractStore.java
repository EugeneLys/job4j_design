package ru.job4j.ood.lsp;

import java.util.List;

public class AbstractStore implements Store {

    List<Food> list;

    public AbstractStore(List<Food> list) {
        this.list = list;
    }

    @Override
    public Food add(Food food) {
        list.add(food);
        return food;
    }

    @Override
    public boolean replace(Food food, List<Food> foods) {
        boolean rsl = false;
        if (food != null || list != null) {
            foods.add(food);
            list.remove(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String name) {
        boolean rsl = false;
        Food found = findByName(name);
        if (found != null) {
            list.remove(found);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> findAll() {
        return list;
    }

    @Override
    public Food findByName(String name) {
        Food rsl = null;
        for (Food food : list) {
            if (name.equals(food.getName())) {
                rsl = food;
            }
        }
        return rsl;
    }
}
