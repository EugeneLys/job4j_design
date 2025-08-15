package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CanCompleteCircuitTest {

    @Test
    void whenCorrect1() {
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        int[] gas = new int[] {2, 3, 4};
        int[] cost = new int[] {3, 4, 3};
        int expected = -1;
        int result = canCompleteCircuit.canCompleteCircuit(gas, cost);
        assertThat(result == expected).isTrue();
    }

}