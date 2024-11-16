package ru.job4j.ood.dip;

public class AquariumService {

    Aquarium aquarium;

    /*
    * Возвращаемое значение метода (поиска животных по имени) зависит от реализации класса Shark,
    * Предпочтительнее было бы сделать так, чтобы метод возвращал экземпляр любого класса, реализующего
    * интерфейс SeaAnimal: "public SeaAnimal getAnimal(String name)"
    * Чтобы метод стал универсальным */

    public Shark getAnimal(String name) {
        return new Shark();
    }
}