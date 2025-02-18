package ru.job4j.newcoll.tree;

import ru.job4j.collection.SimpleQueue;

import java.util.ArrayList;

public class TreeUtils<T> {

    /**
     * Метод выполняет обход дерева и считает количество узлов
     * @param root корневой узел дерева
     * @return количество узлов
     * @throws IllegalArgumentException если root является null
     */
    public int countNode(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        int result = 1;
        queue.push(root);
        Node<T> node = queue.poll();
        while (node != null) {
            if (node.getChildren().isEmpty()) {
                break;
            }
            for (Node<T> n : node.getChildren()) {
                    queue.push(n);
                    result++;
            }
            node = queue.poll();
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
        if (root == null) {
            throw new IllegalArgumentException();
        }
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        queue.push(root);
        ArrayList<T> list = new ArrayList<>();
        list.add(root.getValue());
        Node<T> node = queue.poll();
        while (node != null) {
            if (node.getChildren().isEmpty()) {
                break;
            }
            for (Node<T> n : node.getChildren()) {
                queue.push(n);
                list.add(n.getValue());
            }
            node = queue.poll();
        }
        return list;
    }
}