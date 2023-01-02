package org.ljnpng.algorithm.array;

/**
 * same as
 * @see N0370GetModifiedArray
 */
public class N1109CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            // 题目 编号是从 1 开始
            int sInx = booking[0] - 1;
            int eInx = booking[1] - 1;
            int inc = booking[2];

            diff[sInx] += inc;
            if (eInx < n - 1) {
                diff[eInx + 1] -= inc;
            }
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }
        return diff;

    }
}
