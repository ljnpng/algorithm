package org.ljnpng.algorithm.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0128LongestConsecutiveTest {

    @Test
    void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assertEquals(4, new N0128LongestConsecutive().longestConsecutive(nums));
    }

    @Test
    void test_1() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertEquals(9, new N0128LongestConsecutive().longestConsecutive(nums));
    }

}