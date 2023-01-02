package org.ljnpng.algorithm.array;

/**
 * [[2,1,5],[3,5,7]] 3
 * res 0 2
 */
public class N1094CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for (int[] trip : trips) {
            int inc = trip[0];
            int from = trip[1];
            int to = trip[2] - 1; // 这个位置 乘客已经下车，所以[from,to)
            diff[from] += inc;
            if (to < diff.length - 1) {
                diff[to + 1] -= inc;
            }
        }
        if (diff[0] > capacity) {
            return false;
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }

        }
        return true;
    }
}
