package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class MergeTwoArraysTest {

    @Test
    void merge() {
        MergeTwoArrays mergeTwoArrays = new MergeTwoArrays();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[] {2, 5, 6};
        int n = 3;
        int[] result = new int[] {1, 2, 2, 3, 5, 6};
        mergeTwoArrays.merge(nums1, m, nums2, n);
        assertThat(Arrays.equals(nums1, new int[]{1, 2, 2, 3, 5, 6})).isTrue();
    }
}