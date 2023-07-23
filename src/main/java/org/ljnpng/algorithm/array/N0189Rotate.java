package org.ljnpng.algorithm.array;

public class N0189Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        for (int i = 0; i < n; i++) {
            int p = (n + (i - (k % n))) % n;
            nums[i] = copy[p];
        }
    }
}
