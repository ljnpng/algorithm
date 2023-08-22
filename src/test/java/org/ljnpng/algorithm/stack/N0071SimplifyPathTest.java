package org.ljnpng.algorithm.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0071SimplifyPathTest {

    @Test
    void test() {
        assertEquals("/home", new N0071SimplifyPath().simplifyPath("/home/"));
        assertEquals("/", new N0071SimplifyPath().simplifyPath("/../"));
        assertEquals("/home/foo", new N0071SimplifyPath().simplifyPath("/home//foo/"));
        assertEquals("/c", new N0071SimplifyPath().simplifyPath("/a/./b/../../c/"));
        assertEquals("/c", new N0071SimplifyPath().simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/a/b/c", new N0071SimplifyPath().simplifyPath("/a//b////c/d//././/.."));
    }

}