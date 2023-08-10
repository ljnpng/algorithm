package org.ljnpng.algorithm.array.two;

import java.math.BigInteger;

public class N0073SetZeros {

    public void setZeroes(int[][] matrix) {
        // 只有 = 0 or != 0 两种 情况, 所以可以用二进制标识
        BigInteger row = BigInteger.ZERO;
        BigInteger col = BigInteger.ZERO;
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row = row.or(BigInteger.ONE.shiftLeft(i));
                    col = col.or(BigInteger.ONE.shiftLeft(j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (row.testBit(i)) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (col.testBit(i)) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
