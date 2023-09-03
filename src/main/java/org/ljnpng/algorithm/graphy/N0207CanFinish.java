package org.ljnpng.algorithm.graphy;

import java.util.ArrayList;
import java.util.List;

public class N0207CanFinish {

    /**
     * 记录节点状态 0:未访问 1:正在访问(他的后序节点还没访问完, 还没回溯) 2:已访问
     */
    private int[] visited;
    private List<List<Integer>> edges; // 记录每个节点的邻居

    private boolean valid = true; // 存在环 false


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>()); // 初始化每个节点的邻居
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                //每次从未访问的节点开始遍历后序节点
                dfs(i);
            }
        }

        return valid;
    }

    public void dfs(int i) {
        visited[i] = 1;
        for (Integer edge : edges.get(i)) {
            if (visited[edge] == 0) {
                dfs(edge);
                if (!valid) {
                    // 已经在其他分支中发现环, 直接返回. 属于优化
                    return;
                }
            } else if (visited[edge] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}
