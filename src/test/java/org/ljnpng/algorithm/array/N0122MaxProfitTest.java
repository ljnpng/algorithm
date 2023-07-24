package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0122MaxProfitTest {

    @Test
    public void test1() {
        int[] prices = {7,1,5,3,6,4};
        int expected = 7;
        int actual = new N0122MaxProfit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_price_is_descending() {
        int[] prices = {7,6,4,3,1};
        int expected = 0;
        int actual = new N0122MaxProfit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_price_is_ascending() {
        int[] prices = {1,2,3,4,5};
        int expected = 4;
        int actual = new N0122MaxProfit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_price_is_empty() {
        int[] prices = {};
        int expected = 0;
        int actual = new N0122MaxProfit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_price_is_null() {
        int[] prices = null;
        int expected = 0;
        int actual = new N0122MaxProfit().maxProfit(prices);
        assertEquals(expected, actual);
    }

    @Test
    public void test_price_is_one_element() {
        int[] prices = {1};
        int expected = 0;
        int actual = new N0122MaxProfit().maxProfit(prices);
        assertEquals(expected, actual);
    }




}