package org.ljnpng.algorithm.array;

public class N0238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new UnsupportedOperationException();
        }
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        ans[n - 1] = suffix[n - 1] * prefix[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }
}
