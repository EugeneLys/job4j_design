package ru.job4j.algo;

import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int end;
        for (int i = 0; i < prices.length; i++) {
            map.put(i, prices[i]);
        }
        for (int i = 0; i < map.size() - 1; i++) {
            end = i + 1;
            while (end < map.size()) {
                if (map.get(end) > map.get(i) && map.get(end) - map.get(i) > max) {
                    max = map.get(end) - map.get(i);
                }
                if (end < map.size()) {
                    end++;
                } else {
                    break;
                }
            }
        }
        return max;
    }
}