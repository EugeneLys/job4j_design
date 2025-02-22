package ru.job4j.newcoll.tree;

import ru.job4j.collection.SimpleQueue;
import ru.job4j.collection.SimpleStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * Метод обходит дерево root и добавляет к узлу с ключом parent
     * новый узел с ключом child, при этом на момент добавления узел с ключом parent
     * уже должен существовать в дереве, а узла с ключом child в дереве быть не должно
     * @param root корень дерева
     * @param parent ключ узла-родителя
     * @param child ключ узла-потомка
     * @return true если добавление произошло успешно и false в обратном случае.
     * @throws IllegalArgumentException если root является null
     */
    public boolean add(Node<T> root, T parent, T child) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        boolean result = false;
        Optional<Node<T>> node = findByKey(root, parent);
        //Optional<Node<T>> check = findByKey(root, child);
        if (node.isPresent() /*&& check.isEmpty()*/) {
            List<Node<T>> children = node.get().getChildren();
            children.add(new Node<>(child));
            node.get().setChildren(children);
            result = true;
        }
        return result;
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> findByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        int count = countNode(root);
        Node<T> result = null;
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        Node<T> node = stack.pop();
        while (count > 0) {
            count--;
            if (node.getValue() == key) {
                result = node;
                break;
            }
            for (Node<T> n : node.getChildren()) {
                if (n != null) {
                    stack.push(n);
                    count++;
                }
            }
            if (count == 0) {
                break;
            }
            count--;
            node = stack.pop();
        }
        return result == null ? Optional.empty() : Optional.of(result);
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key,
     * при этом из дерева root удаляется все поддерево найденного узла
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> divideByKey(Node<T> root, T key) {

        return findByKey(root, key);
    }
}