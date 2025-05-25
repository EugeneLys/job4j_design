package ru.job4j.algo;

import java.util.List;

public class BankMaxLoadTime {

    public static int[] findMaxLoadTime(List visitTimes) {
        if (visitTimes.isEmpty()) {
            return null;
        }

        int start = ((int[]) visitTimes.get(0))[0];
        int end = ((int[]) visitTimes.get(0))[1];
        int maxLoadStartTime = start;
        int count = 0;
        int temp = 0;
        for (int i = 1; i < visitTimes.size(); i++) {
            while (((int[]) visitTimes.get(i))[0] <= end) {
                end = Math.min(end, ((int[]) visitTimes.get(i))[1]);
                start = Math.max(start, ((int[]) visitTimes.get(i))[0]);
                temp++;
                if (i < visitTimes.size() - 1) {
                    i++;
                } else {
                    break;
                }
            }
            if (temp > count) {
                count = temp;
                maxLoadStartTime = start;
            }
            temp = 0;

        }
        return new int[]{maxLoadStartTime, maxLoadStartTime + 1};
    }

     static class Event implements Comparable<Event> {
        int time;
        EventType type;

        Event(int time, EventType type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.type == EventType.ARRIVAL ? -1 : 1;
            }
            return Integer.compare(this.time, other.time);
        }
    }

    enum EventType {
        ARRIVAL, DEPARTURE
    }
}