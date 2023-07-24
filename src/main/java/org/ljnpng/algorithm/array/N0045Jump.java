package org.ljnpng.algorithm.array;

public class N0045Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0; // 每一步的最远距离
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(i + nums[i], maxPosition); // end1 和 end2 之间所有元素能在这次的跳跃中最远跳到多远
            if (i == end) {
                // 假设第一步从0 最远能跳到2, 那么 end = 2 的时候, 共尝试了 nums[1] 和 nums[2], 不管哪个1 和2 哪个能跳得更远, 在[1, 2]之间一定会跳一次
                end = maxPosition;
                steps++;
            }
        }
        return steps;

    }
}
