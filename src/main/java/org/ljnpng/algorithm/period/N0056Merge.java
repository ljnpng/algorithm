package org.ljnpng.algorithm.period;

import java.util.Arrays;
import java.util.Comparator;

public class N0056Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        int n = intervals.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int low = intervals[i][0];
            int high = intervals[i][1];

            while (i + 1 < n && intervals[i + 1][0] >= low && intervals[i + 1][0] <= high) {
                high = Math.max(intervals[i + 1][1], high);
                i++;
            }
            intervals[cur][0] = low;
            intervals[cur][1] = high;
            cur++;
        }
        return Arrays.copyOf(intervals, cur);
    }
}
