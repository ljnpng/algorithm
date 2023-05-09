package org.ljnpng.algorithm.array.two;

public class N0327CountRangeSum {

    private int count;
    private long[] temp;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.count = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + (long) nums[i];
        }
        temp = new long[preSum.length];
        sort(preSum, 0, preSum.length - 1, lower, upper);
        return count;
    }

    private void sort(long[] preSum, int lo, int hi, int lower, int upper) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(preSum, lo, mid, lower, upper);
        sort(preSum, mid + 1, hi, lower, upper);
        merge(preSum, lo, mid, hi, lower, upper);
    }

    private void merge(long[] preSum, int lo, int mid, int hi, int lower, int upper) {
        int l = mid + 1, r = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (l <= hi && preSum[l] - preSum[i] < lower) {
                l++;
            }
            while (r <= hi && preSum[r] - preSum[i] <= upper) {
                r++;
            }
            count += r - l;
        }
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if (preSum[i] <= preSum[j]) {
                temp[k++] = preSum[i++];
            } else {
                temp[k++] = preSum[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = preSum[i++];
        }
        while (j <= hi) {
            temp[k++] = preSum[j++];
        }
        System.arraycopy(temp, lo, preSum, lo, hi - lo + 1);
    }
}
