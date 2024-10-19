package ru.job4j.ood.isp.circus;

public class Illusionist implements Circus {

    @Override
    public void showTrick() {
        System.out.println("I do trick.");
    }

    /*
    МЕТОДЫ НЕ РЕАЛИЗУЮТСЯ.
     */
    @Override
    public void amuse() {
    }

    @Override
    public void trainALion() {
    }

    @Override
    public void acrobaticElement() {
    }
}
