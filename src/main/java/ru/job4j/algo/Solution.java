package ru.job4j.algo;

import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        char[] array = s.toCharArray();
        int delta = 1;
        char[] temp = new char[array.length - 1];
        if (check(array, '(', ')')) {
            result.add(s);
            return result;
        }
        while (result.isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                System.arraycopy(array, 0, temp, 0, i);
                System.arraycopy(array, i + delta, temp, i, array.length - delta - i);
                if (check(temp, '(', ')')) {
                    String str = new String(temp);
                    if (!result.contains(str)) {
                        result.add(str);
                    }
                }
            }
            delta++;
        }
        return result.isEmpty() ? List.of("") : result;
    }
        private boolean check(char[] chars, char left, char right) {
            boolean b = false;
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == left) {
                    count++;
                } else if (chars[i] == right){
                    count--;
                }
                if (count < 0) {
                    return false;
                }
            }
            if (count == 0) {
                b = true;
            }
        return  b;
    }
}
