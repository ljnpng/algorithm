package org.ljnpng.algorithm.period;

import java.util.ArrayList;
import java.util.List;

public class N0057Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int l = newInterval[0];
        int h = newInterval[1];

        List<int[]> res = new ArrayList<>(n);
        int i = 0;
        while (i < n && intervals[i][1] < l) {
            // 前置不影响的数组
            res.add(intervals[i]);
            i++;
        }
        int newLow = i < n ? Math.min(intervals[i][0], l) : l;
        while (i < n && intervals[i][0] <= h) {
            i++;
        }

        int newHigh = i > 0 && i - 1 < n ? Math.max(intervals[i - 1][1], h) : h;

        res.add(new int[]{newLow, newHigh});
        while (i < n) {
            // 后置不影响的数组
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[][]{});
    }
}
