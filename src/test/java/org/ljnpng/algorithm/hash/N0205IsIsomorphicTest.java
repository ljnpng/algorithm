package org.ljnpng.algorithm.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0205IsIsomorphicTest {

    @Test
    void isIsomorphic() {
        assertTrue(new N0205IsIsomorphic().isIsomorphic("egg", "add"));
        assertFalse(new N0205IsIsomorphic().isIsomorphic("foo", "bar"));
        assertTrue(new N0205IsIsomorphic().isIsomorphic("paper", "title"));
    }

}