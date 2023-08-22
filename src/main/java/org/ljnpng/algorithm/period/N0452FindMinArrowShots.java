package org.ljnpng.algorithm.period;

import java.util.Arrays;
import java.util.Comparator;

public class N0452FindMinArrowShots {

    /**
     * 其实就是找交并区间
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // 按第二个元素排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int n = points.length;

        // 贪心算法
        // 1. 从第一个区间开始，射箭的位置为第一个区间的右边界
        // 2. 如果下一个区间的左边界大于射箭的位置，则需要再射一箭，射箭的位置为下一个区间的右边界
        // 3. 如果下一个区间的左边界小于等于射箭的位置，则不需要再射一箭，射箭的位置为下一个区间的右边界和当前射箭的位置的最小值
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

}
