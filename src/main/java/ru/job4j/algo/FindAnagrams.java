package ru.job4j.algo;

import java.util.*;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        char[] temp = s.toCharArray();
        char[] temp2 = p.toCharArray();
        Map<Character, Integer> checker = new HashMap();
        Map<Character, Integer> runner = new HashMap();
        for (char c : temp2) {
            checker.compute(c, (key, count) -> count == null ? 1 : count + 1);
        }
        for (int i = 0; i < p.length() - 1; i++) {
            runner.compute(temp[i], (key, count) -> count == null ? 1 : count + 1);
        }
        for (int i = 0; i < temp.length - p.length() + 1; i++) {
            runner.compute(temp[i + p.length() - 1], (key, count) -> count == null ? 1 : count + 1);
            if (checker.get(temp[i]) != null) {
                if (runner.equals(checker)) {
                    result.add(i);
                }
            }
            runner.compute(temp[i], (key, count) -> count == 1 ? null : count - 1);
        }
        return result;
    }
}
