package org.ljnpng.algorithm.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0502FindMaximizedCapitalTest {

    @Test
    void test_0() {
        int maximizedCapital = new N0502FindMaximizedCapital().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        assertEquals(4, maximizedCapital);
    }

}