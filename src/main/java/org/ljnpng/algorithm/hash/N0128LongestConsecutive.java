package org.ljnpng.algorithm.hash;

import java.util.HashSet;
import java.util.Set;

public class N0128LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                // 可以当作起点, 开始向上查找
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    curNum++;
                }

                max = Math.max(max, curNum - num + 1);
            }
        }
        return max;
    }
}
