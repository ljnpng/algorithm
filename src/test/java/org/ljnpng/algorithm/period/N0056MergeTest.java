package org.ljnpng.algorithm.period;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0056MergeTest {

    @Test
    void test() {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] result = new N0056Merge().merge(intervals);
        assertArrayEquals(new int[][]{{1,6},{8,10},{15,18}}, result);
    }

    @Test
    void test_1() {
        int[][] intervals = new int[][]{{1,4},{4,5}};
        int[][] result = new N0056Merge().merge(intervals);
        assertArrayEquals(new int[][]{{1,5}}, result);
    }

    @Test
    void test_2() {
        int[][] intervals = new int[][]{{1,4}};
        int[][] result = new N0056Merge().merge(intervals);
        assertArrayEquals(new int[][]{{1,4}}, result);
    }
}