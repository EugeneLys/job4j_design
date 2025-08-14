package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FindAnagramsTest {

    @Test
    void whenCorrect1() {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = List.of(0, 6);
        List<Integer> expected = findAnagrams.findAnagrams(s, p);
        assertThat(list.equals(expected)).isTrue();
    }

    @Test
    void whenCorrect2() {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "abab";
        String p = "ab";
        List<Integer> list = List.of(0, 1, 2);
        List<Integer> expected = findAnagrams.findAnagrams(s, p);
        assertThat(list.equals(expected)).isTrue();
    }

    @Test
    void whenCorrect3() {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "ababababab";
        String p = "aab";
        List<Integer> list = List.of(0, 2, 4, 6);
        List<Integer> expected = findAnagrams.findAnagrams(s, p);
        System.out.println(expected);
        assertThat(list.equals(expected)).isTrue();
    }

}