package org.ljnpng.algorithm.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0150EvalRPNTest {

    @Test
    void evalRPN() {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        assertEquals(9, new N0150EvalRPN().evalRPN(tokens));
    }

    @Test
    void evalRPN2() {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};
        assertEquals(6, new N0150EvalRPN().evalRPN(tokens));
    }

    @Test
    void evalRPN3() {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(22, new N0150EvalRPN().evalRPN(tokens));
    }


}