package org.ljnpng.algorithm.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0219ContainsNearbyDuplicateTest {

    @Test
    void test1() {
        int[] nums = {1,2,3,1};
        int k = 3;
        boolean result = new N0219ContainsNearbyDuplicate().containsNearbyDuplicate(nums, k);
        assertTrue(result);
    }

    @Test
    void test2() {
        int[] nums = {1,0,1,1};
        int k = 1;
        boolean result = new N0219ContainsNearbyDuplicate().containsNearbyDuplicate(nums, k);
        assertTrue(result);
    }

}