package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0114HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
