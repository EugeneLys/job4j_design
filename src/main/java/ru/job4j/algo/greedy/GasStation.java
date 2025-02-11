package ru.job4j.algo.greedy;

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        int start = 0;
        int totalGas = 0, totalCost = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            start = i;
            int count = gas.length;
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
                    tank = 0;
                    totalGas = 0;
                    totalCost = 0;
                    break;
                }
            }
            if (totalGas != 0 && totalGas >= totalCost) {
                result = i;
            }
        }
        return result;
    }
}