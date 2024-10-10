package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shop extends AbstractStore {

    public Shop(List<Food> list) {
        super(list);
    }

    public static void main(String[] args) {
        List<Store> stores = new ArrayList<>();
        /*stores.add(new Warehouse(List.of(new Food("1", new Date(10), new Date(1), 100, 0),
                new Food("1", new Date(20), new Date(2), 200, 0),
                new Food("1", new Date(30), new Date(3), 300, 0))));*/
    }
}
