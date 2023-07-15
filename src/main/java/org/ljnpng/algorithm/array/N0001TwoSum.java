package org.ljnpng.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class N0001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sorted = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sorted.containsKey(target - nums[i])) {
                return new int[]{sorted.get(target - nums[i]), i};
            }
            sorted.put(nums[i], i);
        }
        return null;
    }
}
