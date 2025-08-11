package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonoArrayTest {

    @Test
    void whenTrue1() {
        MonoArray monoArray = new MonoArray();
        int[] array = new int[] {1, 1, 3, 4};
        assertTrue(monoArray.check(array));
    }

    @Test
    void whenTrue2() {
        MonoArray monoArray = new MonoArray();
        int[] array = new int[] {1, 1, 1, 1};
        assertTrue(monoArray.check(array));
    }

    @Test
    void whenTrue3() {
        MonoArray monoArray = new MonoArray();
        int[] array = new int[] {4, 3, 2, 1};
        assertTrue(monoArray.check(array));
    }

    @Test
    void whenTrue4() {
        MonoArray monoArray = new MonoArray();
        int[] array = new int[] {4, 4, 4, 1};
        assertTrue(monoArray.check(array));
    }

    @Test
    void whenFalse1() {
        MonoArray monoArray = new MonoArray();
        int[] array = new int[] {4, 3, 1, 2};
        assertFalse(monoArray.check(array));
    }

    @Test
    void whenFalse2() {
        MonoArray monoArray = new MonoArray();
        int[] array = new int[] {1, 2, 4, 3};
        assertFalse(monoArray.check(array));
    }
}