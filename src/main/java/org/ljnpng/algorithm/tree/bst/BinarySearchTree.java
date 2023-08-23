package org.ljnpng.algorithm.tree.bst;

/**
 * 二叉搜索树
 * 二叉搜索树是一种特殊的二叉树，它的每个节点的值都大于其左子树的所有节点的值，小于其右子树的所有节点的值。
 */
public class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        insert(root, value);
    }

    public void insert(Node current, int value) {
        if (current == null) {
            current = new Node(value);
            return;
        }

        if (value < current.value) insert(current.left, value);
        else insert(current.right, value);
    }

    public void delete(int value) {
        delete(root, value);
    }

    public void delete(Node current, int value) {
        if (current == null) return;

        if (value < current.value) delete(current.left, value);
        else if (value > current.value) delete(current.right, value);
        else {
            if (current.left == null || current.right == null) {
                current = current.left == null ? current.right : current.left;
            } else {
                Node minNode = findMinNode(current.right);
                current.value = minNode.value;
                delete(current.right, minNode.value);
            }
        }
    }

    public Node findMinNode(Node current) {
        if (current == null) return null;

        if (current.left == null) return current;

        return findMinNode(current.left);
    }


    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node current) {
        if (current == null) return; // 递归终止条件

        inOrder(current.left);
        System.out.println(current.value);
        inOrder(current.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node current) {
        if (current == null) return; // 递归终止条件

        System.out.println(current.value);
        preOrder(current.left);
        preOrder(current.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node current) {
        if (current == null) return; // 递归终止条件

        postOrder(current.left);
        postOrder(current.right);
        System.out.println(current.value);
    }
}
