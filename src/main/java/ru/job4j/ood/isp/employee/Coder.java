package ru.job4j.ood.isp.employee;

public class Coder implements Employee {

    /*
    МЕТОД НЕ РЕАЛИЗУЕТСЯ
     */
    @Override
    public void searchForACandidate() {
    }

    /*
    МЕТОД НЕ РЕАЛИЗУЕТСЯ
     */
    @Override
    public void signContract() {
    }

    @Override
    public void interview() {
        System.out.println("Interview a candidate.");
    }

    @Override
    public void writeCode() {
        System.out.println("Writing code.");
    }

    @Override
    public void commit() {
        System.out.println("Commit and push anyway.");
    }
}
