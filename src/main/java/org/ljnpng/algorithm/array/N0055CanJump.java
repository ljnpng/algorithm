package org.ljnpng.algorithm.array;

public class N0055CanJump {
    public boolean canJump(int[] nums) {
        int maxStep = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= maxStep) {
                maxStep = Math.max(maxStep, nums[i] + i);
                if (maxStep >= n - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;

    }
}