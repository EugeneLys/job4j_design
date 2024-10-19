package ru.job4j.ood.isp.circus;

public interface Circus {
/*
Интерфейс определяет разные методы цирковых артистов - акробата, фокусника, дрессировщика, клоуна.
В классах часть методов не будет использоваться.
=> нарушается ISP.
 */

    void showTrick();

    void amuse();

    void trainALion();

    void acrobaticElement();
}
