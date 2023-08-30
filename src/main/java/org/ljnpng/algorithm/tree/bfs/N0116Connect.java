package org.ljnpng.algorithm.tree.bfs;

import org.ljnpng.algorithm.domain.Node;

import java.util.LinkedList;
import java.util.Queue;

public class N0116Connect {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i == size - 1) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    /**
     * 转化为三叉树
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) return null;
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right.next;
        traverse(left.left, left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }
}
