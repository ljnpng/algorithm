package org.ljnpng.algorithm.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0215FindKthLargestTest {

    @Test
    void findKthLargest() {
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int ans = new N0215FindKthLargest().findKthLargest(nums, k);
        assertEquals(4, ans);
    }
}