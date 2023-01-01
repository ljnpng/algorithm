package org.ljnpng.algorithm.array;

public class N0303SumRange {
    private int[] preSum;

    public N0303SumRange(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        // preSum[right + 1] 存储 0 - right 的总和
        return preSum[right + 1] - preSum[left];
    }
}
