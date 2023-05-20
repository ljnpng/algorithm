package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0700SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(root.val > val ? root.left : root.right, val);
    }

    // enhance searchBST
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }
        return root;
    }
}
