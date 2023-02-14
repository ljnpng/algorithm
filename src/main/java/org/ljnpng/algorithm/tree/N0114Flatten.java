package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0114Flatten {

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;

        // left 置空
        root.left = null;
        // 左子树作为右子树
        root.right = left;

        // 将原先右子树加在新右子树的*最后面*
        TreeNode p = root;
        while (p.right != null) {
            // 遍历到最后的节点
            p = p.right;
        }
        p.right = right;

    }
}
