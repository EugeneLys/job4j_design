package ru.job4j.algo.hash;

import java.util.HashMap;

public class LongestUniqueSubstring {
    /*
     * Метод использует объект HashMap
     * для быстрого (O(1)) поиска дубликата в последовательности символов строки
     */
    public static String longestUniqueSubstring(String str) {
        var result = "";
        char[] array = str.toCharArray();
        var map = new HashMap<Character, Byte>();
        Byte b = 0;
        int cursor = 0, length = 0, max = 0;
        for (int i = 0; i < array.length; i++) {
            while (!map.containsKey(array[i])) {
                map.put(array[i], b);
                length++;
                if (i < array.length - 1) {
                    i++;
                }
            }
            if (length > max) {
                result = str.substring(cursor, cursor + length);
                max = length;
            }
            i = cursor++;
            length = 0;
            map.clear();
            }
        return result;
    }
}
