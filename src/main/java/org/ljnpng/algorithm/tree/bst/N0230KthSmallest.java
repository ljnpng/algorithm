package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class N0230KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        if (leftCount == k - 1) {
            return root.val;
        } else if (leftCount > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    int ret;
    int rank;
    public int kthSmallest3(TreeNode root, int k) {
        traverse(root, k);
        return ret;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            ret = root.val;
            return;
        }
        traverse(root.right, k);
    }

}
