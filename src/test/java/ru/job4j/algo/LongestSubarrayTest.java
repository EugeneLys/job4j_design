package ru.job4j.algo;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LongestSubarrayTest {

    @Test
    void whenCorrect() {
        LongestSubarray longestSubarray = new LongestSubarray();
        int[] array = new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int result = longestSubarray.longestSubarray(array);
        int expected = 5;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenCorrect2() {
        LongestSubarray longestSubarray = new LongestSubarray();
        int[] array = new int[] {1, 1, 0, 1};
        int result = longestSubarray.longestSubarray(array);
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenCorrect3() {
        LongestSubarray longestSubarray = new LongestSubarray();
        int[] array = new int[] {1, 1, 1};
        int result = longestSubarray.longestSubarray(array);
        int expected = 2;
        assertThat(result).isEqualTo(expected);
    }

}