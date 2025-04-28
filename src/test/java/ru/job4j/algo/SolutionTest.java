package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void whenCorrect() {
        Solution solution = new Solution();
        String str = "()())()";
        List<String> expected = List.of("(())()","()()()");
        assertThat(expected).isEqualTo(solution.removeInvalidParentheses(str));
    }

    @Test
    void whenCorrect2() {
        Solution solution = new Solution();
        String str = ")(f";
        List<String> expected = List.of("f");
        assertThat(expected).isEqualTo(solution.removeInvalidParentheses(str));
    }

    /*void whenCorrect() {
        Solution solution = new Solution();
        char [][] chars = new char[][] {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int expected = 1;
        int result = solution.numIslands(chars);
        assertThat(expected).isEqualTo(result);
    }*/

   /* @Test
    void whenCorrect2() {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 3, 7, 5, 10, 3};
        int fee = 3;
        int result = solution.maxProfit(nums, fee);
        assertThat(6).isEqualTo(result);
    }

    @Test
    void whenCorrect3() {
        Solution solution = new Solution();
        int[] nums = new int[] {1, 4, 6, 2, 8, 3, 10, 14};
        int fee = 3;
        int result = solution.maxProfit(nums, fee);
        assertThat(13).isEqualTo(result);
    }*/
}