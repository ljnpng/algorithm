package org.ljnpng.algorithm.tree.bfs;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.*;

public class N0103ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();

        Deque<TreeNode> leftToRight = new LinkedList<>();
        Deque<TreeNode> rightToLeft = new LinkedList<>();
        rightToLeft.push(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            if (!leftToRight.isEmpty()) {
                while (!leftToRight.isEmpty()) {
                    TreeNode node = leftToRight.pop();
                    item.add(node.val);
                    if (node.right != null) {
                        rightToLeft.push(node.right);
                    }
                    if (node.left != null) {
                        rightToLeft.push(node.left);
                    }
                }
            } else {
                while (!rightToLeft.isEmpty()) {
                    TreeNode node = rightToLeft.pop();
                    item.add(node.val);
                    if (node.left != null) {
                        leftToRight.push(node.left);
                    }
                    if (node.right != null) {
                        leftToRight.push(node.right);
                    }
                }
            }
            res.add(item);
        }
        return res;
    }
}
