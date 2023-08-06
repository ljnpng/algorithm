package org.ljnpng.algorithm.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0003LengthOfLongestSubstringTest {

    @Test
    void testLengthOfLongestSubstring() {
        assertEquals(3, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
        assertEquals(0, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring(""));
        assertEquals(1, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring(" "));
        assertEquals(2, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring("au"));
        assertEquals(3, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
        assertEquals(5, new N0003LengthOfLongestSubstring().lengthOfLongestSubstring("tmmzuxt"));
    }

}