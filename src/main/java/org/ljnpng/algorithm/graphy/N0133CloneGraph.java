package org.ljnpng.algorithm.graphy;

import java.util.*;

public class N0133CloneGraph {
    private static final class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // 这种有可能造成递归循环的都需要将以往的排除掉
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return visited.get(node);
    }


    public Node bfs(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> bfsVisited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        bfsVisited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            Node clone = bfsVisited.get(poll);
            for (Node neighbor : poll.neighbors) {
                if (!bfsVisited.containsKey(neighbor)) {
                    bfsVisited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                clone.neighbors.add(bfsVisited.get(neighbor));
            }
        }
        return bfsVisited.get(node);
    }
}
