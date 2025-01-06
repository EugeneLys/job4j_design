package ru.job4j.algo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    /*@Test
    void whenCorrect() {
        Solution solution = new Solution();
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"));
        assertEquals(solution.groupAnagrams(strs), expected);
    }*/

    @Test
    void whenEmpty() {
        Solution solution = new Solution();
        String[] strs = new String[] {"", ""};
        List<List<String>> expected = List.of(List.of("", ""));
        assertEquals(solution.groupAnagrams(strs), expected);
    }

}