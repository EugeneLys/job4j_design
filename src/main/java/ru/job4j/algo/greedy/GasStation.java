package ru.job4j.algo.greedy;

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = -1;
        int i = 0;
        int totalGas = 0, totalCost = 0, tank = 0, stars = 0;
        int next = 0;
        while (i < gas.length) {
            start = i;
            while (start != gas.length - (gas.length - i) + 1) {
                totalGas += gas[start];
                totalCost += cost[start];
                tank += gas[start] - cost[start];
                start++;
                if (tank < 0) {
                    tank = 0;
                    break;
                }
            }
            if (totalGas > totalCost) {
                break;
            }
            i++;
            start = -1;
        }
        return start;
    }
}