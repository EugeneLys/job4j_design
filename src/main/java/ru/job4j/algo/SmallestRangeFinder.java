package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    static int first;
    static int count;

    public static int[] findSmallestRange(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            first = i;
            count = 1;
            while (nums[i] < nums[i + 1]) {
                count++;
                if (count == k) {
                    return new int[] {first, first + count - 1};
                }
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}