package ru.job4j.algo;

import java.util.*;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int total = 0;
        int tempIndex;
        int currIndex = 0;
        int temp;
        int tempProfit = 0;
        int current = prices[0];
        for (int i = 1; i < prices.length; i++) {
            while (i < prices.length - 1 && prices[i] <= current + fee) {
                i++;
            }
            temp = prices[i];
            tempIndex = i;
            while (tempIndex < prices.length - 1 && prices[tempIndex] - fee < temp) {
                tempIndex++;
            }
            if (prices[tempIndex] - fee >= temp) {
                temp = prices[tempIndex];
            }
            total += temp - current - fee;
            if (i < prices.length - 1) {
                current = prices[i + 1];
            }
        }
        return total;
    }
}
