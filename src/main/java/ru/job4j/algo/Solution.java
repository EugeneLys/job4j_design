package ru.job4j.algo;

import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int next = 0, count = 0;
        double temp = 0;
        double res;
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            while (count < k) {
                tree.put(nums[i + count], nums[i + count]);
                count++;
            }
            count = k - tree.size() % 2 == 0 ? tree.size() / 2 : (tree.size() + 1) / 2;
            while (count > 0) {
                temp = (double) tree.pollFirstEntry().getValue();
                count--;
            }
            res = k % 2 == 0 && tree.size() > 1 ? (temp + (double) tree.pollFirstEntry().getValue()) / 2 : temp;
            result[next++] = res;
            tree.clear();
            count = 0;
        }
        return result;
    }
}