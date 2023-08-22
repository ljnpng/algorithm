package org.ljnpng.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class N0020Isvalid {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) return false;

        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        char pop;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            pop = stack.pop();
            if (c == ')' && pop != '(') {
                return false;
            }

            if (c == ']' && pop != '[') {
                return false;
            }
            if (c == '}' && pop != '{') {
                return false;
            }

        }
        return stack.isEmpty();
    }

}
