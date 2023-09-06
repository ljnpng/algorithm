package org.ljnpng.algorithm.graphy;

import java.util.*;

public class N0797AllPathsSourceTarget {

    private List<List<Integer>> ans = new ArrayList();

    private Deque<Integer> queue = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        queue.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    private void dfs(int[][] graph, int i, int n) {
        if (i == n) {
            ans.add(new ArrayList<>(queue));
            return;
        }

        for (int item : graph[i]) {
            queue.offerLast(item);
            dfs(graph, item, n);
            queue.pollLast();
        }
    }
}
