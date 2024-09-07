package ru.job4j.solid;

public class Game {

    public void start() {

    }

    public void finish() {

    }

    public Object createPlayer() {
        return new Object();
    }

    public String setPlayerName() {
        return "";
    }

    public Object createGameField() {
        return new Object();
    }

    public void setFieldDimensions() {

    }
    /*
    класс для некоторой компьютерной игры.
    нарушается принцип единственной ответственности -
    методы для создания игрока, его имени, методы и методы по созданию игрового поля
    нужно вынести в отдельные классы (например, Player и Field)
     */
}
