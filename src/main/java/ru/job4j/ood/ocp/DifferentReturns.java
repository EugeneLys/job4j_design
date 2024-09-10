package ru.job4j.ood.ocp;

public class DifferentReturns {

    public static String ret(String s) {
        return s;
    }

    public static int ret(int i) {
        return i;
    }

    public static double ret(double d) {
        return d;
    }

    public static boolean ret(boolean b) {
        return b;
    }

    /*
    Нарушением OCP является создание множества методов для каждого типа переменных.
    Правильно будет использовать абстракицю: создать один метод ret(), обрабатывающий любой тип данных.
     */

    public static <T> T ret(T t) {
        return t;
    }

    public static void main(String[] args) {
        System.out.println(ret(1));
    }
}
