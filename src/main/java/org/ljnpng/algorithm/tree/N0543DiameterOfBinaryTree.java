package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0543DiameterOfBinaryTree {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return res;
    }

    private int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxLength(root.left);
        int right = maxLength(root.right);
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
}
