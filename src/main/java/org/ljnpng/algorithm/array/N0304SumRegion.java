package org.ljnpng.algorithm.array;

/**
 * 前缀和算法，也是简单的动态规划
 */
public class N0304SumRegion {

    /**
     * 0 0 0 0 0
     * 0 1 2 3 4
     * 0 2 4 6 8
     * 0 3 6 9 12
     *
     * preSum 相当于多出外圈的0 方便计算 1 这些元素的和, 避免越界处理
     */
    private int[][] preSum;

    public N0304SumRegion(int[][] matrix) {
        preSum = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[i].length; j++) {
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}
