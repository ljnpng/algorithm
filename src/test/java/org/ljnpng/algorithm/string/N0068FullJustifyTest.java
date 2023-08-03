package org.ljnpng.algorithm.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0068FullJustifyTest {

    @Test
    void test_1() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        String[] expected = {"This    is    an", "example  of text", "justification.  "};
        assertArrayEquals(expected, new N0068FullJustify().fullJustify(words, maxWidth).toArray());
    }

    @Test
    void test_2() {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        String[] expected = {"What   must   be", "acknowledgment  ", "shall be        "};
        assertArrayEquals(expected, new N0068FullJustify().fullJustify(words, maxWidth).toArray());
    }


}