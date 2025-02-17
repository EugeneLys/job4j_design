package ru.job4j.newcoll.tree;

import ru.job4j.collection.SimpleQueue;

public class TreeUtils<T> {

    /**
     * Метод выполняет обход дерева и считает количество узлов
     * @param root корневой узел дерева
     * @return количество узлов
     * @throws IllegalArgumentException если root является null
     */
    public int countNode(Node<T> root) {
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        int result = 0;
        /*TODO реализуйте метод.*/
        while (queue.iterator().hasNext()) {
            queue.iterator().next();
            result++;
        }
        return result;
    }

    /**
     * Метод выполняет обход дерева и возвращает коллекцию ключей узлов дерева
     * @param root корневой узел
     * @return коллекция с ключами, реализующая интерфейс Iterable<E>
     * @throws IllegalArgumentException если root является null
     */
    public Iterable<T> findAll(Node<T> root) {
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        /*TODO реализуйте метод.*/
        return (Iterable<T>) queue;
    }
}