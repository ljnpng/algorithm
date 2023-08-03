package org.ljnpng.algorithm.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0028StrStrTest {

    @Test
    void test_1() {
        assertEquals(2, new N0028StrStr().strStr("hello", "ll"));
    }

    @Test
    void test_2() {
        assertEquals(-1, new N0028StrStr().strStr("aaaaa", "bba"));
    }

    @Test
    void test_3() {
        assertEquals(0, new N0028StrStr().strStr("", ""));
    }

    @Test
    void test_4() {
        assertEquals(0, new N0028StrStr().strStr("a", ""));
    }

}