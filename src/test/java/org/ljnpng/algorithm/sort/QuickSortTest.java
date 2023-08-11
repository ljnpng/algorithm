package org.ljnpng.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    void test_1() {
        int[] arr = {3, 2, 1, 5, 4};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void test_2() {
        int[] arr = {3, 2, 1, 5, 4, 6};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, arr);
    }

    @Test
    void test_big() {
        int[] arr = {3, 2, 1, 5, 4, 6, 9, 8, 7, 10, 11, 12, 13, 14, 15};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, arr);
    }

    @Test
    void test_include_same_element() {
        int[] arr = {3, 2, 1, 5, 4, 6, 9, 8, 7, 10, 11, 12, 13, 14, 15, 3};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, arr);
    }

    @Test
    void test_len_is_zero() {
        int[] arr = {};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void test_len_is_one() {
        int[] arr = {1};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }

}