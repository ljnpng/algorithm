package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class N0173BSTIterator {

    Queue<Integer> queue = new LinkedList<>();

    public N0173BSTIterator(TreeNode root) {
        init(root);
    }

    private void init(TreeNode root) {
        if (root == null) {
            return;
        }

        init(root.left);
        queue.offer(root.val);
        init(root.right);
    }

    public int next() {
        if (!hasNext()) {
            throw new UnsupportedOperationException();
        }
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
