package org.ljnpng.algorithm.array;

public class N0121Profit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(prices[i - 1], min);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
