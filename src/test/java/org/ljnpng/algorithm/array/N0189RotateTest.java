package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0189RotateTest {

    @Test
    public void test_k_greater_than_length() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 8;
        int[] expected = {7,1,2,3,4,5,6};
        new N0189Rotate().rotate(nums, k);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test_k_equal_to_zero() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 0;
        int[] expected = {1,2,3,4,5,6,7};
        new N0189Rotate().rotate(nums, k);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test_k_equal_to_length() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 7;
        int[] expected = {1,2,3,4,5,6,7};
        new N0189Rotate().rotate(nums, k);
        assertArrayEquals(expected, nums);
    }

}