package org.ljnpng.algorithm.array;

public class N0134CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0; // 尝试从 i 出发
        while (i < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            int cnt = 0; // 前进 cnt 个加油站
            while (cnt < n) {
                int j = (cnt + i) % n; // 目前位于第j个加油站
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfGas < sumOfCost) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
