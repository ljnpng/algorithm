package org.ljnpng.algorithm.array.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0059GenerateMatrixTest {

    N0059GenerateMatrix service = new N0059GenerateMatrix();

    @Test
    void testGenerateMatrix() {
        int[][] matrix = service.generateMatrix(4);
        assertEquals(4, matrix[0][3]);
        assertEquals(7, matrix[3][3]);
        assertEquals(10, matrix[3][0]);

    }

}