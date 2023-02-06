package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        swapLeftAndRight(root);
        traverse(root.left);
        traverse(root.right);
    }

    private void swapLeftAndRight(TreeNode root) {
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
    }

    /**
     * enhancement 分解子问题
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
