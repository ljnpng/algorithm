package org.ljnpng.algorithm.array.two;

public class N0036IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] square = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int index = c - '0' - 1; // 里面的是1 - 9 所以得 -1
                rows[i][index]++;
                cols[index][j]++;
                square[i / 3][j / 3][index]++;
                if (rows[i][index] > 1
                        || cols[index][j] > 1
                        || square[i / 3][j / 3][index] > 1) {
                    return false;
                }
            }

        }
        return true;
    }
}
