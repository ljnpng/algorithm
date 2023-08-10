package org.ljnpng.algorithm.array.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0289GameOfLifeTest {

    @Test
    void test_1() {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}};
        int[][] expected = new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 0}};
        new N0289GameOfLife().gameOfLife(board);
        assertArrayEquals(expected, board);
    }

    @Test
    void test_2() {
        int[][] board = new int[][]{
                {1, 1},
                {1, 0}};
        int[][] expected = new int[][]{
                {1, 1},
                {1, 1}};
        new N0289GameOfLife().gameOfLife(board);
        assertArrayEquals(expected, board);
    }

}