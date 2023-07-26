package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0238ProductExceptSelfTest {

    @Test
    void test_1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        int[] actual = new N0238ProductExceptSelf().productExceptSelf(nums);
        assertArrayEquals(expected, actual);
    }

    @Test
    void test_2() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        int[] actual = new N0238ProductExceptSelf().productExceptSelf(nums);
        assertArrayEquals(expected, actual);
    }

}