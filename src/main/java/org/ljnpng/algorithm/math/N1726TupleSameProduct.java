package org.ljnpng.algorithm.math;

import java.util.HashMap;
import java.util.Map;

public class N1726TupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int item = nums[i] * nums[j];
                dic.put(item, dic.getOrDefault(item, 0) + 1);
            }
        }
        int ans = 0;
        for (Integer v : dic.values()) {
            ans += v * (v - 1) * 4; // n/2 * (n - 1) * 8 每一个有8种变体
        }
        return ans;
    }
}
