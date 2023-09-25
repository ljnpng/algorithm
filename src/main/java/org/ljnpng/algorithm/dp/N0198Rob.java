package org.ljnpng.algorithm.dp;

public class N0198Rob {

    public int rob(int[] nums) {
        int prev = 0;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int next = Math.max(nums[i] + prev, curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
