package org.ljnpng.algorithm.tree.bst;

/**
 * AVL树
 * AVL树是一种自平衡二叉搜索树, 任何节点的两个子树的高度最大差别为1
 * 通过旋转操作来进行平衡(四种)
 */
public class AVLTree {

    private static class Node {
        int data;
        Node left;
        Node right;
        int height;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        return reBalance(node);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }


    private Node rightRotate(Node node) {
        Node left = node.left;
        Node right = left.right;

        left.right = node;
        node.left = right;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        left.height = 1 + Math.max(height(left.left), height(left.right));

        return left;
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        Node left = right.left;

        right.left = node;
        node.right = left;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        right.height = 1 + Math.max(height(right.left), height(right.right));

        return right;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            // 没有找到要删除的节点
            return null;
        }

        if (data < node.data) {
            // 向左子树继续查找
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            // 向右子树继续查找
            node.right = delete(node.right, data);
        } else {
            // 找到了要删除的节点
            if (node.left == null || node.right == null) {
                // 要删除的节点只有一个子节点或者没有子节点
                node = node.left == null ? node.right : node.left;
            } else {
                // 要删除的节点有两个子节点, 找到右子树中最小的节点, 用它来替换要删除的节点
                Node temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }

                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }

        if (node == null) {
            return null;
        }

        // 更新高度
        node.height = 1 + Math.max(height(node.left), height(node.right));

        return reBalance(node);
    }

    private Node reBalance(Node node) {
        // 检查平衡性
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            // LL, 失衡节点的左子树的左子树上插入了节点
            return rightRotate(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            // LR, 失衡节点的左子树的右子树上插入了节点
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            // RR, 失衡节点的右子树的右子树上插入了节点
            return leftRotate(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.print(node.data + " ");
        print(node.right);
    }
}
