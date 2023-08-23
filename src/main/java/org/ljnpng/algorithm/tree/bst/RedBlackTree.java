package org.ljnpng.algorithm.tree.bst;

/**
 * 红黑树
 * <p>
 * 1. 每个节点或者是黑色，或者是红色。
 * 2. 根节点是黑色。
 * 3. 每个叶子节点（NIL）是黑色。
 * 4. 如果一个节点是红色的，则它的子节点必须是黑色的。
 * 5. 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
 * <p>
 * 1. 红黑树是一种近似平衡的二叉查找树。
 * 2. 在插入和删除操作中，保持了良好的平衡，性能稳定。
 * 3. 没有最坏情况的出现，查找、插入、删除时间复杂度均为 O(logN)。
 */
public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private int key;
        private Node left, right;
        private boolean color;

        public Node(int key) {
            this.key = key;
            this.color = RED;
        }

        @Override
        public String toString() {
            return String.format("%02d", key) + (color ? "R" : "B");
        }
    }

    private Node root;

    public void put(int key) {
        root = put(root, key);
        root.color = BLACK;
    }

    private Node put(Node node, int key) {
        // 递归终止条件
        if (node == null) return new Node(key);

        // 定位插入位置
        if (key < node.key) node.left = put(node.left, key);
        else if (key > node.key) node.right = put(node.right, key);

        return fixColor(node);
    }

    private Node fixColor(Node node) {
        // 修复红黑树性质
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node); // 当前节点右子节点为红色，左子节点为黑色，左旋, 保证性质4
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node); // 当前节点左子节点为红色，左子节点的左子节点为红色，右旋, 保证性质4
        if (isRed(node.left) && isRed(node.right)) flipColors(node); // 当前节点左右子节点均为红色，颜色翻转, 保证性质5

        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
        if (root != null) root.color = BLACK;
    }

    private Node delete(Node node, int key) {
        // 递归终止条件
        if (node == null) return null;

        // 定位删除位置
        if (key < node.key) node.left = delete(node.left, key);
        else if (key > node.key) node.right = delete(node.right, key);
        else {
            // 删除节点
            if (node.left == null || node.right == null) {
                node = node.left == null ? node.right : node.left;
            } else {
                Node min = node.right;
                while (min.left != null) min = min.left;
                node.key = min.key;
                node.right = delete(node.right, min.key);
            }
        }

        // 修复红黑树性质
        return fixColor(node);
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        // 当前节点右子节点为红色，左子节点为黑色，左旋, 保证性质4
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    private Node rotateRight(Node node) {
        // 当前节点左子节点为红色，左子节点的左子节点为红色，右旋, 保证性质4
        Node x = node.left;
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    private void flipColors(Node node) {
        // 当前节点左右子节点均为红色，颜色翻转, 保证性质5
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

}
