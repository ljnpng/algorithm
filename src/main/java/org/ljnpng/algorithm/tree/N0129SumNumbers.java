package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0129SumNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return traverse(0, root);

    }

    public int traverse(int preSum, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return traverse(sum, root.left) + traverse(sum, root.right);
    }

}
