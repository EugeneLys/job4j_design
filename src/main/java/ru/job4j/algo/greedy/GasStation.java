package ru.job4j.algo.greedy;

class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        var result = -1;
        int totalGas, totalCost, tank;
        int count;
        int start;
        for (int i = 0; i < gas.length; i++) {
            start = i;
            count = gas.length;
            tank = 0;
            totalGas = 0;
            totalCost = 0;
            while (count > 0) {
                totalGas += gas[start];
                totalCost += cost[start];
                tank += gas[start] - cost[start];
                start++;
                if (start == gas.length) {
                    start = 0;
                }
                count--;
                if (tank < 0) {
                    break;
                }
            }
            if (totalGas != 0 && totalGas >= totalCost) {
                result = i;
                break;
            }
        }
        return result;
    }
}