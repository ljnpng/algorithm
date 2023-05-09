package org.ljnpng.algorithm.array.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0327CountRangeSumTest {


    @Test
    void testCountRangeSum() {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        int expected = 3;
        int actual = new N0327CountRangeSum().countRangeSum(nums, lower, upper);
        assertEquals(expected, actual);
    }

}