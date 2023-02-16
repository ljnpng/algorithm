package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0654ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int index = maxIndex(nums, 0, nums.length - 1);
        TreeNode left = constructMaxTree(nums, 0, index - 1);
        TreeNode right = constructMaxTree(nums, index + 1, nums.length - 1);
        return new TreeNode(nums[index], left, right);
    }

    private TreeNode constructMaxTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int inx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                inx = i;
                max = nums[i];
            }
        }
        return new TreeNode(nums[inx], constructMaxTree(nums, left, inx - 1), constructMaxTree(nums, inx + 1, right));
    }

    private int maxIndex(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int inx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                inx = i;
                max = nums[i];
            }
        }
        return inx;
    }
}
