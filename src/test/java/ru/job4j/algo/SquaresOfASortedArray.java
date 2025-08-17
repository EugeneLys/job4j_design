package ru.job4j.algo;

import java.util.PriorityQueue;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[index] = nums[i] * nums[i];
                i++;
            } else {
                result[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }
        return result;
    }
}
