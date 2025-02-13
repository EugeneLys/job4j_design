package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void whenCorrect() {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 2};
        int result = solution.maxProfit(nums);
        assertThat(1).isEqualTo(result);
    }
}