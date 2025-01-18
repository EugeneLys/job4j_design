package ru.job4j.algo.sort;

import java.util.Arrays;

public class Merge {

    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, res = 0;
        while (l < left.length && r < right.length) {
            result[res++] = left[l] <= right[r] ? left[l++] : right[r++];
        }
        while (l < left.length) {
            result[res++] = left[l++];
        }
        while (r < right.length) {
            result[res++] = right[r++];
        }
        return result;
    }
}
