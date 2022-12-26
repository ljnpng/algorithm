package org.ljnpng.algorithm.linkednode.reverse;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import static org.junit.jupiter.api.Assertions.*;

class N0234IsPalindromeTest {

    private N0234IsPalindrome n0234IsPalindrome = new N0234IsPalindrome();
    @Test
    void testEvenListNode() {
        ListNode node = Utils.stringToListNode("[1,2,2,1]");
        assertTrue(n0234IsPalindrome.isPalindrome(node));
    }

    @Test
    void testOddListNode() {
        ListNode node = Utils.stringToListNode("[1,0,1]");
        assertTrue(n0234IsPalindrome.isPalindrome(node));
    }

    @Test
    void testEmptyListNode() {
        ListNode node = Utils.stringToListNode("[]");
        assertTrue(n0234IsPalindrome.isPalindrome(node));
    }

    @Test
    void testSingleListNode() {
        ListNode node = Utils.stringToListNode("[1]");
        assertTrue(n0234IsPalindrome.isPalindrome(node));
    }


    @Test
    void testDoubleListNode() {
        ListNode node = Utils.stringToListNode("[1,1]");
        assertTrue(n0234IsPalindrome.isPalindrome(node));

        node = Utils.stringToListNode("[1, 2]");
        assertFalse(n0234IsPalindrome.isPalindrome(node));
    }



}