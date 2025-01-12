package ru.job4j.algo;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int length = intervals.length;
        int i = 0;
        while (i < intervals.length - 1) {
            while (intervals[i] == null && i < intervals.length - 1) {
                i++;
            }
            int cursor = i + 1;
            while (cursor < intervals.length && intervals[cursor] != null && intervals[i][1] >= intervals[cursor][0]) {
                intervals[i] = new int[]{Math.min(intervals[i][0], intervals[cursor][0]),
                        Math.max(intervals[i][1], intervals[cursor][1])};
                intervals[cursor] = null;
                length--;
                if (cursor < intervals.length - 1) {
                    cursor++;
                }
            }
            i++;
        }
        int[][] result = new int[length][];
        int j = 0;
        for (int[] array : intervals) {
            if (array != null) {
                result[j] = array;
                j++;
            }
        }
        return result;
    }
}
