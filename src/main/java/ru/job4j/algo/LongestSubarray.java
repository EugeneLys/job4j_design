package ru.job4j.algo;

class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int position;
        int index = 0;
        int temp = 0;
        int result = 0;
        while (index < nums.length - 1) {
            while (nums[index] == 1) {
                temp++;
                if (index < nums.length - 1) {
                    index++;
                } else {
                    return Math.max(temp - 1, result);
                }
            }
            index++;
                position = index;

                if (index < nums.length) {
                    while (nums[index] == 1) {
                        temp++;
                        if (index < nums.length - 1) {
                            index++;
                        } else {
                           return Math.max(temp, result);
                        }
                    }
                    result = Math.max(temp, result);
                        temp = 0;
                    }
                    index = position;
                }
        return result;
    }
}
