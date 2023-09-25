package org.ljnpng.algorithm.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinFallingPathSumTest {

    @Test
    void minFallingPathSum() {
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int result = new N0931MinFallingPathSum().minFallingPathSum(A);
        assertEquals(12, result);

        // n = 1 边界
        A = new int[][]{{1}};
        result = new N0931MinFallingPathSum().minFallingPathSum(A);
        assertEquals(1, result);

        // n = 2 边界
        A = new int[][]{{1,2},{3,4}};
        result = new N0931MinFallingPathSum().minFallingPathSum(A);
        assertEquals(4, result);


    }

}