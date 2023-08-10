package org.ljnpng.algorithm.array.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0073SetZerosTest {

    @Test
    void test_1() {
        int[][] matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};

        new N0073SetZeros().setZeroes(matrix);

        assertArrayEquals(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}}, matrix);
    }

    @Test
    void test_2() {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        new N0073SetZeros().setZeroes(matrix);

        assertArrayEquals(new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}}, matrix);
    }

}