package ru.job4j.solid;

import java.util.List;

public interface SimplyInterface {

    List<String> generate();
    void sort();

    /*
    два метода в одном интерфейсе, преследующие разные цели -
    создания списка и его сортировки.
    Это нарушение принципа единственной ответственности
     */
}
