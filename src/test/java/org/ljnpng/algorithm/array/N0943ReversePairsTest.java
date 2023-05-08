package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0943ReversePairsTest {

    @Test
    public void testReversePairs() {
        int[] nums = {1, 3, 2, 3, 1};
        int result = new N0943ReversePairs().reversePairs(nums);
        assertEquals(2, result);
    }

}