package org.ljnpng.algorithm.period;

import java.util.ArrayList;
import java.util.List;

public class N0228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        int n = nums.length;
        List<String> res = new ArrayList<>();

        while (start < n) {
            int low = start;
            while (start + 1 < n && nums[start + 1] == nums[start] + 1) {
                start++;
            }

            StringBuilder sb = new StringBuilder().append(nums[low]);
            if (start != low) {
                sb.append("->").append(nums[start]);
            }
            res.add(sb.toString());
            start++;
        }
        return res;
    }
}
