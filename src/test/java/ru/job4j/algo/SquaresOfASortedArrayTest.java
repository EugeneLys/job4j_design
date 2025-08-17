package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class SquaresOfASortedArrayTest {

    @Test
    void sortedSquares() {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        int[] array = new int[] {-4, -1, 0, 3, 10};
        int[] result = new int[] {0, 1, 9, 16, 100};
        assertThat(Arrays.equals(squaresOfASortedArray.sortedSquares(array), result)).isTrue();
    }
}