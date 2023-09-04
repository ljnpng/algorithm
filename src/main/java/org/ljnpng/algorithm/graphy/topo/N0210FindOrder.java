package org.ljnpng.algorithm.graphy.topo;

import java.util.*;

public class N0210FindOrder {


    private Deque<Integer> stack = new LinkedList<>();
    private boolean valid = true; // 存在环即false

    private List<List<Integer>> edges = new ArrayList<>();

    private int[] visited; // 0 未访问, 1 访问中, 2 已完成

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 初始化节点
            edges.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[]{};
        }

        int i = 0;
        int[] res = new int[numCourses];
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (Integer edge : edges.get(i)) {
            if (visited[edge] == 0) {
                dfs(edge);
                if (!valid) {
                    return;
                }
            } else if (visited[edge] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
        stack.push(i);
    }
}
