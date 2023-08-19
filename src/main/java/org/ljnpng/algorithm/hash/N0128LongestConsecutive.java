package org.ljnpng.algorithm.hash;

import java.util.Arrays;

public class N0128LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                cur++;
            } else {
                if (nums[i] - nums[i - 1] == 1) {
                    cur++;
                } else if(nums[i] - nums[i - 1] == 0) {
                    continue;
                } else {
                    max = Math.max(cur, max);
                    cur = 1;
                }
            }
        }
        return Math.max(cur, max);
    }
}
