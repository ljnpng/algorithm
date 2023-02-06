package org.ljnpng.algorithm.tree;


import org.ljnpng.algorithm.domain.TreeNode;

public class N0104MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
