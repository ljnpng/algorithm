package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0135CandyTest {

    @Test
    void test_1() {
        int[] ratings = {1, 0, 2};
        int expected = 5;
        int actual = new N0135Candy().candy(ratings);
        assertEquals(expected, actual);
    }

    @Test
    void test_2() {
        int[] ratings = {1, 2, 2};
        int expected = 4;
        int actual = new N0135Candy().candy(ratings);
        assertEquals(expected, actual);
    }

    @Test
    void test_3() {
        int[] ratings = {1, 3, 2, 2, 1};
        int expected = 7;
        int actual = new N0135Candy().candy(ratings);
        assertEquals(expected, actual);
    }

    @Test
    void test_length_1() {
        int[] ratings = {1};
        int expected = 1;
        int actual = new N0135Candy().candy(ratings);
        assertEquals(expected, actual);
    }

}