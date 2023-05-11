package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0538ConvertBST {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        root.val += sum;
        sum = root.val;
        traverse(root.left);
    }

}
