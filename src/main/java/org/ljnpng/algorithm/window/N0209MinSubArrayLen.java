package org.ljnpng.algorithm.window;

public class N0209MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        long cur = 0L;
        int res = n + 1;
        while (right < n) {
            cur += nums[right];
            if (cur >= target) {
                res = Math.min(right - left + 1, res);
                while (left <= right && cur >= target) {
                    cur -= nums[left];
                    left++;
                    if (cur >= target) {
                        res = Math.min(right - left + 1, res);
                    }
                }
            }
            right++;
        }
        return res == n + 1 ? 0 : res;
    }
}
