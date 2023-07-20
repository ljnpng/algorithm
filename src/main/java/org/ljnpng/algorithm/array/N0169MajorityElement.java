package org.ljnpng.algorithm.array;

import java.util.Arrays;

public class N0169MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
