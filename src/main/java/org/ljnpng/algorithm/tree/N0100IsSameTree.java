package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0100IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        if (q.val != p.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
