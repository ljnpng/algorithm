package org.ljnpng.algorithm.tree.bst;

/**
 * B 树
 * <p>
 * B 树是一种平衡的多路搜索树，它的每个节点最多包含 k 个孩子，k 被称为 B 树的阶。
 * B 树的阶取决于磁盘页的大小，通常阶为 100 或 1000。
 * B 树的搜索、插入和删除的时间复杂度都是 O(log n)。
 * B 树的每个节点包含两种类型的数据：
 */
public class BTree {

    private int order; // B 树的阶

    private Node root;

    public BTree(int order) {
        this.order = order;
        this.root = new Node();
    }

    public void insert(int key) {
        Node node = this.root;
        if (node.count == order - 1) {
            Node newRoot = new Node();
            this.root = newRoot;
            newRoot.leaf = false;
            newRoot.count = 0;
            newRoot.children[0] = node;
            splitChild(newRoot, 0, node);
            insertNonFull(newRoot, key);
        } else {
            insertNonFull(node, key);
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.count - 1;
        if (node.leaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.count++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            i++;
            if (node.children[i].count == order - 1) {
                splitChild(node, i, node.children[i]);
                if (key > node.keys[i]) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(Node parent, int index, Node child) {
        Node newChild = new Node();
        newChild.leaf = child.leaf;
        newChild.count = order / 2 - 1;
        for (int i = 0; i < order / 2 - 1; i++) {
            newChild.keys[i] = child.keys[i + order / 2];
        }
        if (!child.leaf) {
            for (int i = 0; i < order / 2; i++) {
                newChild.children[i] = child.children[i + order / 2];
            }
        }
        child.count = order / 2 - 1;
        for (int i = parent.count; i > index; i--) {
            parent.children[i + 1] = parent.children[i];
        }
        parent.children[index + 1] = newChild;
        for (int i = parent.count - 1; i >= index; i--) {
            parent.keys[i + 1] = parent.keys[i];
        }
        parent.keys[index] = child.keys[order / 2 - 1];
        parent.count++;
    }


    private class Node {
        private int count;
        private int[] keys;
        private Node[] children;
        private boolean leaf;

        public Node() {
            this.count = 0;
            this.keys = new int[order - 1];
            this.children = new Node[order];
            this.leaf = true;
        }
    }

}
