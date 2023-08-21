package org.ljnpng.algorithm.period;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class N0057InsertTest {

    @Test
    void test_1() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] expected = {{1, 5}, {6, 9}};
        int[][] actual = new N0057Insert().insert(intervals, newInterval);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test_2() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] expected = {{1, 2}, {3, 10}, {12, 16}};
        int[][] actual = new N0057Insert().insert(intervals, newInterval);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test_3() {
        int[][] intervals = {};
        int[] newInterval = {5, 7};
        int[][] expected = {{5, 7}};
        int[][] actual = new N0057Insert().insert(intervals, newInterval);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test_4() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        int[][] expected = {{1, 5}};
        int[][] actual = new N0057Insert().insert(intervals, newInterval);
        assertArrayEquals(expected, actual);
    }


}