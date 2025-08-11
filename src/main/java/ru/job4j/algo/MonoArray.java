package ru.job4j.algo;

public class MonoArray {

    boolean check(int[] array) {
        if (array.length == 0) {
            return false;
        }
        if (array.length == 1) {
            return true;
        }
        int left = 0;
        int right;
        if (array[0] <= array[array.length - 1]) {
            while (true) {
                right = left + 1;
                if (array[right] < array[left]) {
                    return false;
                }
                if (left < array.length - 2) {
                    left++;
                } else {
                    break;
                }
            }
        }
        if (array[0] >= array[array.length - 1]) {
            while (true) {
                right = left + 1;
                if (array[right] > array[left]) {
                    return false;
                }
                if (left < array.length - 2) {
                    left++;
                } else {
                    break;
                }
            }
        }
        return true;
    }
}
