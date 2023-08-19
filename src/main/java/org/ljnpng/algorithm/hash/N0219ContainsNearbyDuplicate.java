package org.ljnpng.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class N0219ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> itemIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer preIndex = itemIndex.get(nums[i]);
            if (preIndex != null && i - preIndex <= k) {
                return true;
            }
            itemIndex.put(nums[i], i);
        }
        return false;
    }
}
