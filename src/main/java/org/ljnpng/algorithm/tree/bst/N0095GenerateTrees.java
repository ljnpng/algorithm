package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * <p></p>
 * NOTE: 1 <= n <= 8
 */
public class N0095GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1 || n > 8) {
            throw new IllegalArgumentException("only support 1 <= n <= 8");
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTreeNodes = new LinkedList<>();
        if (start > end) {
            allTreeNodes.add(null);
            return allTreeNodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            allTreeNodes.addAll(generateTrees(i, lefts, rights));
        }
        return allTreeNodes;
    }

    private List<TreeNode> generateTrees(int i, List<TreeNode> lefts, List<TreeNode> rights) {
        List<TreeNode> allTreeNodes = new LinkedList<>();
        for (TreeNode left : lefts) {
            for (TreeNode right : rights) {
                allTreeNodes.add(new TreeNode(i, left, right));
            }
        }
        return allTreeNodes;
    }

}
