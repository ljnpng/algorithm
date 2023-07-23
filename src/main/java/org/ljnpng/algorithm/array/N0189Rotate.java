package org.ljnpng.algorithm.array;

public class N0189Rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] copy = new int[k];
        System.arraycopy(nums, n - k, copy, 0, k);
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        System.arraycopy(copy, 0, nums, 0, k);
    }
}
