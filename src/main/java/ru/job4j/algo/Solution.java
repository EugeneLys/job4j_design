package ru.job4j.algo;

import java.util.*;

class Solution {

    Node root;

    public int numIslands(char[][] grid) {
        if (root == null) {
            root = makeNode(0, 0);
        }
        return 0;
    }

    private Node makeNode(int i, int j) {

    }

    class Node {
        int row;
        int column;
        Node left;
        Node right;
        Node down;
    }
}
