package ru.job4j.algo.sliding.window;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", start, end);
    }
}

public class Main {

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[]{-1, -1};
        }
        PriorityQueue<Interval> activeIntervals = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));
        int maxOverlap = 0;
        int maxStart = -1;
        int maxEnd = -1;

        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0) {
                maxStart = intervals.get(i).start;
                maxEnd = intervals.get(i).end;
                activeIntervals.add(intervals.get(i));
                i++;
            }
            while (i < intervals.size()) {
                if (intervals.get(i).start <= intervals.get(i - 1).end) {
                    maxStart = intervals.get(i).start;
                    activeIntervals.add(intervals.get(i));
                    if (i < intervals.size() - 1) {
                i++;
            }
                    while (i < intervals.size() - 1 && intervals.get(i).start <= intervals.get(i - 1).end) {
                        activeIntervals.add(intervals.get(i));
                        i++;
                    }
                }
                if (activeIntervals.size() > maxOverlap) {
                    maxEnd = activeIntervals.peek().end;
                }
                activeIntervals.clear();

            }
            /*if (i < intervals.size() - 1) {
                i++;
            }*/
        }

            return new int[]{
                    maxStart, maxEnd
            };
        }

        public static void main (String[]args){
            List intervals = new ArrayList<>();
            intervals.add(new Interval(1, 4));
            intervals.add(new Interval(2, 6));
            intervals.add(new Interval(3, 5));
            intervals.add(new Interval(7, 8));

            int[] result = findMaxOverlapInterval(intervals);

            System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}
