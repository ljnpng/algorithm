package org.ljnpng.algorithm.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0076MinWindowTest {

    @Test
    void test_1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        String actual = new N0076MinWindow().minWindow(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void test_2() {
        String s = "a";
        String t = "a";
        String expected = "a";
        String actual = new N0076MinWindow().minWindow(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void test_3() {
        String s = "a";
        String t = "aa";
        String expected = "";
        String actual = new N0076MinWindow().minWindow(s, t);
        assertEquals(expected, actual);
    }

    @Test
    void test_4() {
        String s = "aa";
        String t = "aa";
        String expected = "aa";
        String actual = new N0076MinWindow().minWindow(s, t);
        assertEquals(expected, actual);
    }


    @Test
    void test_5() {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        String expected = "cwae";
        String actual = new N0076MinWindow().minWindow(s, t);
        assertEquals(expected, actual);
    }

}