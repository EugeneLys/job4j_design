package collection.binarytree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public boolean put(T key) {
        boolean result;
        if (Objects.isNull(root)) {
            root = new Node(key);
            result = true;
        } else {
            result = put(root, key);
        }
        return result;
    }

    private boolean put(Node node, T key) {
        //TODO реализуйте метод
        return false;
    }

    public boolean contains(T key) {
        /*TODO реализуйте метод с использованием приватного метода
        private Node find(Node node, T key)*/
        return find(root, key) != null;
    }

    private Node find(Node node, T key) {
        /*TODO реализуйте метод*/
        Node result = null;
        while (node != null) {
            if (node.key.equals(key)) {
                result = node;
                break;
            } else if (node.key.compareTo(key) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return result;
    }

    public boolean remove(T key) {
        /* Метод будет реализован в следующих уроках */
        return false;
    }

    public List<T> inSymmetricalOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inSymmetricalOrder(node, result);
    }

    private List<T> inSymmetricalOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inSymmetricalOrder(localRoot.left, list);
            list.add(localRoot.key);
            inSymmetricalOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPreOrder() {
        //TODO реализуйте метод
        return null;
    }

    private List<T> inPreOrder(Node localRoot, List<T> list) {
        //TODO реализуйте метод
        return null;
    }

    public List<T> inPostOrder() {
        //TODO реализуйте метод
        return null;
    }

    private List<T> inPostOrder(Node localRoot, List<T> list) {
        //TODO реализуйте метод
        return null;
    }

    public T minimum() {
        return Objects.nonNull(root) ? minimum(root).key : null;
    }

    private Node minimum(Node node) {
        //TODO реализуйте метод
        return null;
    }

    public T maximum() {
        return Objects.nonNull(root) ? maximum(root).key : null;
    }

    private Node maximum(Node node) {
        //TODO реализуйте метод
        return null;
    }

    @Override
    public String toString() {
        return PrintTree.getTreeDisplay(root);
    }

    private class Node implements VisualNode {
        private T key;
        private Node left;
        private Node right;

        public Node(T key) {
            this.key = key;
        }

        @Override
        public VisualNode getLeft() {
            return left;
        }

        @Override
        public VisualNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return key.toString();
        }
    }
}