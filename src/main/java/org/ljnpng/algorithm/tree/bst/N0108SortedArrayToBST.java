package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0108SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return generate(nums, 0, nums.length - 1);
    }

    private TreeNode generate(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = generate(nums, left, mid - 1);
        root.right = generate(nums, mid + 1, right);
        return root;
    }
}
