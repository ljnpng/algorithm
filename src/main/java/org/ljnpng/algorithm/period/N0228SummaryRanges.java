package org.ljnpng.algorithm.period;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N0228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        if (nums.length == 1) {
            return Collections.singletonList(String.valueOf(nums[0]));
        }

        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((long)nums[i] - nums[i - 1] > 1L) {
                String s =  i - 1 == start ? String.valueOf(nums[start]) : nums[start] + "->" + nums[i - 1];
                res.add(s);
                start = i;
            }
        }

        String s =  nums.length - 1 == start ? String.valueOf(nums[start]) : nums[start] + "->" + nums[nums.length - 1];
        res.add(s);
        return res;
    }
}
