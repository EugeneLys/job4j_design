package ru.job4j.algo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeTwoArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int count1 = 0;
        int count2 = 0;
        int[] nums3 = Arrays.copyOf(nums1, m);
        for (int i = 0; i < length; i++) {
            while (count1 < m && count2 < n) {
                if (nums3[count1] <= nums2[count2]) {
                    nums1[i++] = nums3[count1++];
                } else {
                    nums1[i++] = nums2[count2++];
                }
            }
            while (count1 < m) {
                nums1[i++] = nums3[count1++];
            }
            while (count2 < n) {
                nums1[i++] = nums2[count2++];
            }
        }
    }
}
