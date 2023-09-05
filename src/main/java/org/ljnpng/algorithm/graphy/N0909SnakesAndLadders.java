package org.ljnpng.algorithm.graphy;

import java.util.LinkedList;
import java.util.Queue;

public class N0909SnakesAndLadders {


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(new int[]{1, 0}); // 起始id 1, 搜索 0次
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if (next > n * n) { // 超出边界
                    break;
                }


                // 有🐍🪜
                int[] rc = numToPos(next, n);
                int i1 = board[rc[0]][rc[1]];
                if (i1 > 0) {
                    next = i1;
                }

                if (next == n * n) { // 到达终点
                    return cur[1] + 1;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cur[1] + 1});
                }
            }
        }
        return -1;
    }

    public int[] numToPos(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if(r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }


}
