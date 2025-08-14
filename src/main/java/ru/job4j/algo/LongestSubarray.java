package ru.job4j.algo;

class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int cursor = 0;
        int temp = 0;
        boolean anyDel = false;
        int previous = 0;
        int del = 0;
        int result = 0;
        while (cursor < nums.length) {
            if (nums[cursor] == 1) {
                temp++;
                cursor++;
            } else {
                anyDel = true;
                if (temp > 0) {
                    del++;
                }

                cursor++;
            }
            if (cursor == nums.length || del > 1) {
                result = anyDel ? Math.max(temp, result) : temp - 1;
                temp = 0;
                del = 0;
            }
        }
        return result;
    }
}
