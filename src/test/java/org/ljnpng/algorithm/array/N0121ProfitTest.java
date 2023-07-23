package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0121ProfitTest {

    @Test
    public void test_1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int actual = new N0121Profit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_2() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        int actual = new N0121Profit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_3() {
        int[] prices = {1, 2};
        int expected = 1;
        int actual = new N0121Profit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_4() {
        int[] prices = {2, 1, 2, 0, 1};
        int expected = 1;
        int actual = new N0121Profit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_prices_is_null() {
        int[] prices = null;
        int expected = 0;
        int actual = new N0121Profit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_prices_is_empty() {
        int[] prices = {};
        int expected = 0;
        int actual = new N0121Profit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_prices_is_one() {
        int[] prices = {1};
        int expected = 0;
        int actual = new N0121Profit().maxProfit(prices);
        assertEquals(expected, actual);
    }




}