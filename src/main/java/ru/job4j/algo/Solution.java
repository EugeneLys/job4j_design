package ru.job4j.algo;

import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int next = 0, count = 0;
        int treeCount = 0;
        double res = 0;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            while (count < k) {
                if (tree.containsKey(nums[i + count])) {
                    treeCount++;
                }
                tree.put(nums[i + count], nums[i + count]);
                count++;
            }
            count = k%2 == 0 ? (k/2 - 1) - treeCount : ((k - 1) / 2) - treeCount;
            while(count > 0) {
                var temp = tree.pollFirstEntry();
                count--;
            }
            res = k%2 == 0 ? ((double)tree.pollFirstEntry().getValue() + (double)tree.pollFirstEntry().getValue()) / 2 : (double) tree.pollFirstEntry().getValue();
            result[next++] = res;
            tree.clear();
            count = 0;
            treeCount = 0;
        }
        return result;
    }
}
