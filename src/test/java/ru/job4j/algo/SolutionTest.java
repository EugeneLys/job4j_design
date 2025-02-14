package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void whenCorrect() {
        Solution solution = new Solution();
        int[] nums = new int[] {1,3,2,8,4,9};
        int fee = 2;
        int result = solution.maxProfit(nums, fee);
        assertThat(8).isEqualTo(result);
    }

    @Test
    void whenCorrect2() {
        Solution solution = new Solution();
        int[] nums = new int[] {1,3,7,5,10,3};
        int fee = 3;
        int result = solution.maxProfit(nums, fee);
        assertThat(6).isEqualTo(result);
    }
}