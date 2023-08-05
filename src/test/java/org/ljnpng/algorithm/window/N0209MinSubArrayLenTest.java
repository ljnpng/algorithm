package org.ljnpng.algorithm.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0209MinSubArrayLenTest {

    @Test
    void minSubArrayLen() {
        assertEquals(2, new N0209MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(1, new N0209MinSubArrayLen().minSubArrayLen(4, new int[]{1, 4, 4}));
        assertEquals(0, new N0209MinSubArrayLen().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

}