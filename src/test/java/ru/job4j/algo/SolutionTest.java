package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void whenCorrect() {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] result = solution.medianSlidingWindow(nums, k);
        assertThat(new double[] {1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000}).containsExactly(result);
    }

    @Test
    void whenCorrect2() {
        Solution solution = new Solution();
        int[] nums = new int[] {2147483647, 2147483647};
        int k = 2;
        double[] result = solution.medianSlidingWindow(nums, k);
        assertThat(new double[] {2147483647}).containsExactly(result);
    }

    @Test
    void whenCorrect3() {
        Solution solution = new Solution();
        int[] nums = new int[] {5, 2, 2, 7, 3, 7, 9, 0, 2, 3};
        int k = 9;
        double[] result = solution.medianSlidingWindow(nums, k);
        assertThat(new double[] {3.00000, 3.00000}).containsExactly(result);
    }

    @Test
    void whenCorrect4() {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 4, 2, 3};
        int k = 4;
        double[] result = solution.medianSlidingWindow(nums, k);
        assertThat(new double[] {2.50000}).containsExactly(result);
    }
}