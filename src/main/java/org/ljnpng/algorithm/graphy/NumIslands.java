package org.ljnpng.algorithm.graphy;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    /**
     * dfs
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i >= nr || j >= nc || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }


        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    private void bfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x < nr && y < nc && x >= 0 && y >= 0 && grid[x][y] == '1') {
                grid[x][y] = '0';
                queue.offer(new int[]{x + 1, y});
                queue.offer(new int[]{x, y + 1});
                queue.offer(new int[]{x - 1, y});
                queue.offer(new int[]{x, y - 1});
            }
        }

    }


}
