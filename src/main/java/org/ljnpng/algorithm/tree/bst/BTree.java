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
            // 只有叶子节点才能插入, 从右往左遍历, 找到合适的位置插入
            // 这个叶子节点已经保证了有空间插入 1
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
                // 如果子节点已经满了, 先分裂
                // 这一步判断是为了保证子节点有空间插入 1
                splitChild(node, i, node.children[i]);
                if (key > node.keys[i]) {
                    // 分裂完后, 再次判断 key 的位置, 只有两种情况, 要么在左边, 要么在右边
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(Node parent, int index, Node child) {
        Node newChild = new Node();
        newChild.leaf = child.leaf;
        int mid = (order - 1) / 2;
        newChild.count = (order - 1) - mid - 1;
        for (int i = 0; i < order / 2 - 1; i++) {
            newChild.keys[i] = child.keys[i + mid + 1];
        }
        if (!child.leaf) {
            for (int i = 0; i < order / 2; i++) {
                newChild.children[i] = child.children[i + mid + 1];
            }
        }
        child.count = mid;
        for (int i = parent.count; i > index; i--) {
            parent.children[i + 1] = parent.children[i];
        }
        parent.children[index + 1] = newChild;
        for (int i = parent.count - 1; i >= index; i--) {
            parent.keys[i + 1] = parent.keys[i];
        }
        parent.keys[index] = child.keys[mid];
        parent.count++;
    }

    public boolean find(int key) {
        return find(this.root, key);
    }

    private boolean find(Node node, int key) {
        int i = 0;
        while (i < node.count && key > node.keys[i]) {
            i++;
        }
        if (i < node.count && key == node.keys[i]) {
            return true;
        }
        if (node.leaf) {
            return false;
        }
        return find(node.children[i], key);
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < count; i++) {
                sb.append(keys[i]);
                if (i != count - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }



}
