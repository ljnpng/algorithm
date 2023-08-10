package org.ljnpng.algorithm.array.two;

import java.util.Arrays;

public class N0289GameOfLife {

    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[] up = new int[m + 2];
        int[] upTmp = new int[m + 2];
        for (int i = 0; i < n; i++) {
            boolean bottom = i == n - 1;
            for (int j = 0; j < m; j++) {
                upTmp[j + 1] = board[i][j];
                board[i][j] = check(new int[]{
                                up[j],
                                up[j + 1],
                                up[j + 2],
                                upTmp[j],
                                j == m - 1 ? 0 : board[i][j + 1],
                                bottom || j == 0 ? 0 : board[i + 1][j - 1],
                                bottom ? 0 : board[i + 1][j],
                                bottom || j == m - 1 ? 0 : board[i + 1][j + 1]
                        },
                        board[i][j]);
            }
            up = Arrays.copyOf(upTmp, m + 2);
            upTmp = new int[m + 2];
        }
    }

    private int check(int[] a, int b) {
        int alive = 0;
        for (int i : a) {
            if (i == 1) {
                alive++;
            }
        }
        if (b == 1) {
            b = alive < 2 || alive > 3 ? 0 : 1;
        } else {
            b = alive == 3 ? 1 : 0;
        }
        return b;
    }
}
