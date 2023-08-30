package org.ljnpng.algorithm.tree;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0236LowestCommonAncestor {

    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        traverse(root, p.val, q.val);
        return res;
    }

    /**
     * @param root
     * @param p
     * @param q
     * @return 00 都没匹配, 10 = 2 = p 匹配, 01 = 1 q 匹配 11 = 3 都匹配
     */
    public int traverse(TreeNode root, int p, int q) {
        if (root == null) {
            return 0;
        }
        int cur = traverse(root.left, p, q) | traverse(root.right, p, q);
        if (root.val == p) {
            cur = cur | 2;
        } else if (root.val == q) {
            cur = cur | 1;
        }
        if (cur == 3) {
            cur = 0;
            res = root;
        }
        return cur;
    }
}
