package ru.job4j.ood.dip;

import java.util.List;

/*
* Класс содержит поле population (список животных в аквариуме)
* и это поле зависит от реализации - класса Shark.
* Предпочтительнее ввести абстракцию - интерфейс SeaAnimal.
* Тогда применение класса Aquarium (при "implements SeaAnimal")
* не будет ограничено возможностями класса Shark
* (и в аквариум можно будет добавлять любых рыб и животных), поле будет: List<SeaAnimal> population;
* */
public class Aquarium {

    List<Shark> population;

}