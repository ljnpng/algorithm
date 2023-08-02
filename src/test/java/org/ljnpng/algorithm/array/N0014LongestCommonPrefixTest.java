package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class N0014LongestCommonPrefixTest {

    @Test
    void test_1() {
        String[] strs = { "flower", "flow", "flight" };
        String result = new N0014LongestCommonPrefix().longestCommonPrefix(strs);
        Assertions.assertEquals("fl", result);

    }


    @Test
    void test_2() {
        String[] strs = { "dog", "racecar", "car" };
        String result = new N0014LongestCommonPrefix().longestCommonPrefix(strs);
        Assertions.assertEquals("", result);

    }

}