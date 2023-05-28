package ru.job4j.io;

import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        return null;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("data/log.txt");
        /* Здесь сделайте построчный вывод содержимого списка log на консоль*/

    }
}
