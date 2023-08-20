package org.ljnpng.algorithm.period;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class N0056Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int low = intervals[i][0];
            int high = intervals[i][1];

            while (i + 1 < n && intervals[i + 1][0] <= high) {
                high = Math.max(intervals[i + 1][1], high);
                i++;
            }
            res.add(new int[]{low, high});
        }
        return res.toArray(new int[][]{});
    }
}
