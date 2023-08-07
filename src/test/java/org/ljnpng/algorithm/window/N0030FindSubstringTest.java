package org.ljnpng.algorithm.window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class N0030FindSubstringTest {

    @Test
    void test_1() {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> expected = List.of(0, 9);
        List<Integer> actual = new N0030FindSubstring().findSubstring(s, words);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        List<Integer> expected = List.of();
        List<Integer> actual = new N0030FindSubstring().findSubstring(s, words);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        List<Integer> expected = List.of(6, 9, 12);
        List<Integer> actual = new N0030FindSubstring().findSubstring(s, words);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_4() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> expected = List.of(8);
        List<Integer> actual = new N0030FindSubstring().findSubstring(s, words);
        Assertions.assertEquals(expected, actual);
    }

}