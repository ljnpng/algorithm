package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0222CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return  0;
        }
        return countNodes(root.left) + countNodes(root.right) +1;
    }
}
