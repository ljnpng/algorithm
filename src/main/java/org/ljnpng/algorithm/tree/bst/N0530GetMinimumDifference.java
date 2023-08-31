package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0530GetMinimumDifference {

    private int ans = Integer.MAX_VALUE;

    private int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }

        traverse(root.right);
    }

}
