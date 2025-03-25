package ru.job4j.algo;

import java.util.*;

class Solution {

    public int numIslands(char[][] grid) {
        int result = 0;
        int lenght1 = grid.length;
        int length2 = grid[0].length;
        for (int i = 0; i < lenght1; i++) {
            for (int j = 0; j < length2; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    mark(grid, i , j);
                }
            }
        }
        return result;
    }

    private void mark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        mark(grid, i, j+1);
        mark(grid, i, j-1);
        mark(grid, i+1, j);
        mark(grid, i-1, j);
    }
}
