package org.ljnpng.algorithm.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0020IsvalidTest {

    @Test
    void isValid() {
        N0020Isvalid n0020Isvalid = new N0020Isvalid();
        assertTrue(n0020Isvalid.isValid("()"));
        assertTrue(n0020Isvalid.isValid("()[]{}"));
        assertFalse(n0020Isvalid.isValid("(]"));
        assertFalse(n0020Isvalid.isValid("([)]"));
        assertTrue(n0020Isvalid.isValid("{[]}"));
    }

}