package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        int left = 0;
        int right;
        while (left <= nums.length - k) {
            right = left + 1;
            while (nums[right] > nums[left] && nums[right] != nums[right - 1]) {
                if (right - left == k - 1) {
                    return new int[] {left, right};
                }
                right++;
            }
            left++;
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