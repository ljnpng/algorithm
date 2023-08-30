package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0124MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(traverse(root.left), 0);
        int right = Math.max(traverse(root.right), 0);

        maxSum = Math.max(maxSum, root.val + left + right);

        return root.val + Math.max(left, right);
    }


}
