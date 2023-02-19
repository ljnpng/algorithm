package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0105BuildTree {

    private int inx = -1;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode(preorder[++inx]);
        int cur = -1;
        for (int i = low; i <= high; i++) {
            if (inorder[i] == preorder[inx]) {
                cur = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, low, cur - 1);
        root.right = buildTree(preorder, inorder, cur + 1, high);
        return root;
    }
}
