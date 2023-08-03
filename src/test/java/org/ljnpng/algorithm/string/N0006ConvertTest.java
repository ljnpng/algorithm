package org.ljnpng.algorithm.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0006ConvertTest {

    @Test
    void test_1() {
        assertEquals("LCIRETOESIIGEDHN", new N0006Convert().convert("LEETCODEISHIRING", 3));
    }

    @Test
    void test_2() {
        assertEquals("LDREOEIIECIHNTSG", new N0006Convert().convert("LEETCODEISHIRING", 4));
    }

    @Test
    void test_3() {
        assertEquals("AB", new N0006Convert().convert("AB", 1));
    }

}