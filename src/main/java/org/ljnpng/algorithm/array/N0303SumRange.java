package org.ljnpng.algorithm.array;

public class N0303SumRange {
    private int[] nums;

    public N0303SumRange(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
