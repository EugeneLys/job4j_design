package ru.job4j.ood.lsp;

import java.util.List;

public class Warehouse extends AbstractStore {

    public Warehouse(List<Food> list) {
        super(list);
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
}