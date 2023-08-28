package org.ljnpng.algorithm.linkednode;

import java.util.HashMap;
import java.util.Map;

public class N0146LRUCache {

    private final DeLinkedNode head;

    private final DeLinkedNode tail;

    private final Map<Integer, DeLinkedNode> cache;

    private int size;

    private final int capacity;

    public N0146LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;

        this.head = new DeLinkedNode();
        this.tail = new DeLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            ++size;
            node = new DeLinkedNode(key, value);
            addToHead(node);
            cache.put(key, node);
            if (size > capacity) {
                DeLinkedNode res = tail.prev;
                removeNode(res);
                cache.remove(res.key);
                size--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DeLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DeLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DeLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private static class DeLinkedNode {
        private DeLinkedNode prev;

        private DeLinkedNode next;

        private int key;

        private int val;

        DeLinkedNode() {
        }

        DeLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


}
