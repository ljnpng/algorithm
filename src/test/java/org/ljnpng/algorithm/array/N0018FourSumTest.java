package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0018FourSumTest {

    @Test
    void fourSum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        N0018FourSum fourSum = new N0018FourSum();
        assertEquals(3, fourSum.fourSum(nums, target).size());

        nums = new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000};
        target = 1000000000;

        assertEquals(1, fourSum.fourSum(nums, target).size());
    }

}