package org.ljnpng.algorithm.graphy;

public class N0547FindCircleNum {

    public int findCircleNum(int[][] isConnected) {

        int provinces = 0;
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;

            }
        }
        return provinces;

    }

    private void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1) {
                dfs(isConnected, visited, cities, j);
            }
        }
    }
}
