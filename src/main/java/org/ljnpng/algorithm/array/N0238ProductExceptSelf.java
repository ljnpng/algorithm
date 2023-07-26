package org.ljnpng.algorithm.array;

public class N0238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new UnsupportedOperationException();
        }
        int n = nums.length;
        int[] ans = new int[n];
        int suffix = 1;

        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            ans[i] *= suffix;
        }
        return ans;
    }
}
