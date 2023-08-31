package org.ljnpng.algorithm.tree.bfs;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.*;

public class N0103ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Deque<Integer> item = new LinkedList<>();
            int size = queue.size();
            leftToRight = !leftToRight;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    item.offerLast(node.val);
                } else {
                    item.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(new LinkedList<>(item));
        }
        return res;
    }
}
