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
    /*
    Метод обеспечивает принудительный полный перебор всех хранилищ и сортировку продуктов в них на текущую дату.
     */
    public void distributeAll() {
        List<Food> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Store store = stores.get(i);
            List<Food> next = store.findAll();
            while (!next.isEmpty()) {
                store.replace(next.get(0), list);
            }
        }
        for (Food f : list) {
            add(f);
        }
    }

    /*
    Метод добавляет "лист" продуктов в хранилища (распределяет по ним)
     */
    public void addList(List<Food> list) {
        for (Food f : list) {
            add(f);
        }
    }

    /*
    Метод добавляет одну единицу продуктов в хранилища.
     */
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
