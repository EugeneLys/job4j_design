package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    List<Store> stores;
    LocalDate today;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
        today = LocalDate.now();
    }

    public ControlQuality(Warehouse warehouse, Shop shop, Trash trash) {
        assert false;
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
        today = LocalDate.now();
    }

    public void distributeAll() {
        List<Food> list = new ArrayList<>();
        for (Store store : stores) {
            for (Food food : store.findAll()) {
                store.replace(food, list);
            }
        }
        for (Food f : list) {
            add(f);
        }
    }

    public void addList(List<Food> list) {
        for (Food f : list) {
            add(f);
        }
    }
    public void add(Food food) {
        long current = ChronoUnit.DAYS.between(today, food.expiryDate);
        long total = ChronoUnit.DAYS.between(food.createDate, food.expiryDate);
        float ratio = (float) current / total;
        int index = 0;
        if (ratio < 0.75) {
            index = 1;
        }
        if (ratio < 0.25) {
            food.setDiscount(20);
        }
        if (ratio <= 0) {
            index = 2;
        }
        stores.get(index).add(food);
    }
}
