package org.ljnpng.algorithm.graphy;

public class N0130Solve {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int nr = board.length;
        int nc = board[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (i == 0 || i == nr - 1 || j == 0 || j == nc - 1) {
                    dsf(board, i, j);
                }
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void dsf(char[][] board, int i, int j) {
        int nr = board.length;
        int nc = board[0].length;
        if (i < 0 || j < 0 || i >= nr || j >= nc || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'B';
        dsf(board, i - 1, j);
        dsf(board, i + 1, j);
        dsf(board, i, j - 1);
        dsf(board, i, j + 1);
    }

}
