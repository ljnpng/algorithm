package org.ljnpng.algorithm.array;

public class N0121Profit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        int[] buyIn = new int[n];
        buyIn[0] = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            buyIn[i] = Math.min(prices[i - 1], buyIn[i - 1]);
            profit = Math.max(profit, prices[i] - buyIn[i]);
        }
        return profit;
    }
}
