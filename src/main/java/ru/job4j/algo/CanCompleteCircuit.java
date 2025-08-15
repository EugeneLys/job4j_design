package ru.job4j.algo;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        int result = 0;
        int balance = 0;
        for (int i = 0; i < gas.length; i++) {
            balance += gas[i] - cost[i];
            if (balance < 0) {
                result = i + 1;
                balance = 0;
            }
        }
        return result;
    }
}
