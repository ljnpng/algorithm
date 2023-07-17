package org.ljnpng.algorithm.array;

import java.util.*;

public class N0018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long tmp = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (tmp == target) {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (tmp > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
