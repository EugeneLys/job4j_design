package ru.job4j.ood.dip;

public class AquariumStore {

    /*
    * Метод принимает в качестве аргумента лишь одну реализацию интерфейса SeaAnimal - класс Shark
    * Соответственно не применим для покупки других рыб и животных
    * Предпочтительнее сделать аргументом метода весь интерфейс SeaAnimal, чтобы можно было купить
    * любое животное в аквариуме: "public void buy(SeaAnimal animal)"
    * */
    public void buy(Shark shark) {
        System.out.println("You have bought a " + shark.getName());
    }
}
