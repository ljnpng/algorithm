package org.ljnpng.algorithm.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0202IsHappyTest {

    @Test
    void isHappy() {
        assertTrue(new N0202IsHappy().isHappy(19));
        assertFalse(new N0202IsHappy().isHappy(2));
    }

}