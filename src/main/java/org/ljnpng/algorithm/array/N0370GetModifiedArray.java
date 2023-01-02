package org.ljnpng.algorithm.array;

/**
 * res 1 2 4 5 6 3
 * dif 1 1 2 1 1 -3
 *
 * op1 1-4 +1
 * res 1 3 5 6 7 3
 * dif 1 2 2 1 1 -4
 */
public class N0370GetModifiedArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length]; // 差分数组 diff[i] = src[i] - src[i - 1]
        for (int[] update : updates) {
            int startInx = update[0];
            int endInx = update[1];
            int inc = update[2];

            diff[startInx] += inc;
            if (endInx < length - 1) {
                diff[endInx + 1] -= inc;
            }
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }
        return diff;
    }
}
