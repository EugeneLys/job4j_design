package ru.job4j.ood.ocp;

public class SuperMarket {

    private boolean severalFloors;
    private String tradingNetwork;
    private boolean metroEntrance;

    public SuperMarket(boolean severalFloors, String tradingNetwork, boolean metroEntrance) {
        this.severalFloors = severalFloors;
        this.tradingNetwork = tradingNetwork;
        this.metroEntrance = metroEntrance;
    }

    public String textYes() {
        return "I'm a supermarket";
    }

    public String textNo() {
        return "I'm not a supermarket";
    }

    static class SmallShop extends SuperMarket {

        public SmallShop(boolean severalFloors, String tradingNetwork, boolean metroEntrance) {
            super(severalFloors, tradingNetwork, metroEntrance);
        }
    }

    public static void main(String[] args) {
        SuperMarket sup = new SuperMarket(true, "Pyaterochka", true);
        System.out.println(sup.textYes());
        SmallShop small = new SmallShop(false, null, false);
        System.out.println(small.textNo());
    }
    /*
    Класс SmallShop наследует класс SuperMarket с нарушением OCP.
    - поля, которые есть в SuperMarket, избыточны для SmallShop (у него всегда один этаж,
    всегда нет принадлежности к торговой сети, всегда нет выхода в метро).
    - приходится добавить метод textNo() для с отдельным возвращаемым результатом для SmallShop.
    То есть приходится менять класс SuperMarket.
     */

}


