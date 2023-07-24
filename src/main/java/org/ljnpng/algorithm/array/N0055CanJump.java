package org.ljnpng.algorithm.array;

public class N0055CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        int maxStep = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (i <= maxStep) {
                maxStep = Math.max(maxStep, nums[i] + i);
                if (maxStep >=n) {
                    return true;
                }
            } else {
                return false;
            }

        }
        return true;

    }
}