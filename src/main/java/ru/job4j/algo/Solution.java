package ru.job4j.algo;

import java.util.*;

class Solution {
    public int maxProfit(int[] prices, int fee) {
    int result = 0;
    int temp;
    int current = prices[0];
    for (int i = 1; i < prices.length; i++) {
        current = Math.min(current, prices[i]);
        if (current < prices[i] - fee) {
            temp = i;
            while (temp < prices.length && prices[temp] > prices[temp - 1] - fee) {
                if (prices[temp] >= prices[i] + fee) {
                    i = temp;
                }
                temp++;
            }
            result += prices[i] - fee - current;
            current = prices[i];
        }
    }
    return result;
    }
}
