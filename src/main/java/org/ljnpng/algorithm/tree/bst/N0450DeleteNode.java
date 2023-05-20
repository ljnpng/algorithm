package org.ljnpng.algorithm.tree.bst;

import org.ljnpng.algorithm.domain.TreeNode;

public class N0450DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            // delete
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode minNode = getMinNode(root.right);
                minNode.right = deleteNode(root.right, minNode.val);
                minNode.left = root.left;
                root = minNode;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMinNode(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }

}
